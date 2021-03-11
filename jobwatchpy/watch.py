import http.client
import json
from bs4 import BeautifulSoup
from indeed import IndeedClient
import requests
import urllib.request as urlrequest
import re
import csv
import sys
import sqlite3 as lite
from datetime import datetime
import time, threading
import schedule
import time
from requests.auth import HTTPBasicAuth
#from datetime import timedelta
from threading import Timer

# Dictionary mapping Keys
keys_map = {}
keys_map['salary_adzuna'] = 'salary_max'
keys_map['salary_jooble'] = 'salary'
keys_map['type_adzuna'] = 'contract_type'
keys_map['type_jooble'] = 'type'
keys_map['link_adzuna'] = 'redirect_url'
keys_map['link_jooble'] = 'link'


CITIES = []
ACCEPTED_COUNTRIES = ['united kingdom' ,'ireland' ,'germany', 'france', 'switzerland', 'italy', 'luxembourg', 'austria', 'denmark', 'belgium', 'poland'] #, 'united states', 'canada', 'germany', 'france',
country_mapping = {'united kingdom': 'gb', 'germany':'de','united states': 'us', 'canada': 'ca', 'france': 'fr',
				   'ireland': 'ie','Switzerland':'ch'}

#blacklist = ['[document]','noscript','header','html','meta','head','input','script','style' ]

with open('lists/list-cities.csv', 'rt')as f:
	data = csv.reader(f)
	i = 0
	for row in data:
		if i==0 :
			i+=1
			continue
		if row[-1].strip().lower() in ACCEPTED_COUNTRIES:
			CITIES.append([row[0].lower(),row[-1].lower()])

######################################################################################################################
#########################   LOADING THE KEYWORDS FOR THE SEARCHES    #################################################
######################################################################################################################
# infotech_file = 'lists/sectors/InformationAndCommunicationsTechnologyOccupations.txt'
# scienceEng_file = 'lists/sectors/ScienceEngineeringOccupations.txt'
# businessAdmin_file = 'lists/sectors/BusinessAdministrationOccupations.txt'
# health_file = 'lists/sectors/HealthOccupations.txt'
# legalSocialCult_file = 'lists/sectors/LegalSocialCulturalOccupations.txt'
# teaching_file = 'lists/sectors/TeachingOccupations.txt'
sectors_files = ['lists/sectors/InformationAndCommunicationsTechnologyOccupations.txt',
				 'lists/sectors/ScienceEngineeringOccupations.txt','lists/sectors/BusinessAdministrationOccupations.txt',
				 'lists/sectors/HealthOccupations.txt','lists/sectors/LegalSocialCulturalOccupations.txt',
				 'lists/sectors/TeachingOccupations.txt']
titles = ['infotech','scienceEng','businessAdmin','health','legalSocialCult','teaching']

sectors = {}
for item,title in zip(sectors_files,titles):
	with open(item) as inf:
		data_list = []
		for row in inf :
			if row.strip() :
				data_list.append(row.strip())
			#data_list.extend([r.strip() for r in row.split(' ') ])
		extend = []
		if title=='infotech':
			extend = [ 'machine', 'manufacture', 'industry', 'models', 'information technology', 'computer',
					   'deep learnig', 'deeplearning', 'programming', 'algorithm', 'innovation', 'database', 'software',
					   'software engineering', 'software engineer', 'physics', 'maths', 'informatics','cloud computing',
					  'analyst', 'analysis', 'data analysis','technology','devops','big data','data science','bigdata']
		elif title=='scienceEng':
			extend = ['chemistry','biology', 'phisics', 'science','engineering', 'engineer', 'physics',]

		data_list.extend(extend)

		sectors[title]=data_list

# Function to check duplicates
def is_duplicate(id,date,company,location,title,description,salary,type,link,table):
	db_file = "db/jobposts"

	# SELECT QUERY
	select_query = "SELECT id, company, title, link FROM "+table+ \
	                    " WHERE `id` LIKE '%"+id.strip()+"%' AND `company` LIKE '"+company.strip()+"'" \
						" AND `title` LIKE '%"+title.strip()+"%' AND `link` LIKE '%"+link.strip()+"%'; "

	con = lite.connect(db_file)
	with con:
		cur = con.cursor()
		cur.execute(select_query)
		data = cur.fetchall()
	if data :
		return True
	else:
		# UPDATE QUERY
		insert_query = "INSERT INTO "+table+"(id, post_date, company, location, title, description, salary, type, link) " \
						"VALUES('"+id.strip()+"', '"+date.strip()+"', '"+company.strip()+"', '"+location.strip()+"'," \
						" '"+title.strip()+"', '"+description.strip()+"', '"+salary.strip()+"', '"+type+"', '"+link.strip()+"');"
		try:
			with con:
				cur = con.cursor()
				cur.execute(insert_query)
				con.commit()
		except:
			pass
		return False

# SAVING FUNCTION
def save_to_file(file_name,annotations):
	annons = annotations.split('\n')

	with open(file_name,"a+") as of:
		for line in annons:
			of.write(line+"\n")
	of.close()

# Skip through each job and fetch page contents
def process_reslts(results, connection, kind='jooble'):
	for job in results:
		time.sleep(3)
		# Skip through each job and fetch page contents
		title = ""+ str(job['title'])
		title = re.sub('<[^<]+?>', '',title)
		id = ""+ str(job['id'])
		description = ''
		salary = ''
		company = ''
		location = ''
		date = ''
		type = 'Full time'
		link = ""

		if kind == 'adzuna':
			try:
				location += " ".join(job['location']['area'][1:])+ " , " +job['location']['area'][0] #[-1] + "," + job['location']['area'][0]
			except:
				pass

			try:
				company += " "+ job['company']['display_name']
			except:
				pass

			try:
				description += job['description']
			except:
				pass

			try:
				date += str(job['created'])
			except:
				pass
		else:
			try:
				company = ""+ job['company']
			except:
				pass
			try:
				location = ""+job['location']
			except:
				pass
			try:
				description += job['snippet']
			except:
				pass
			try:
				date = ""+ job['updated']
			except:
				pass

		try:
			salary += ""+job[keys_map['salary_'+kind]]
		except:
			pass
		try:
			type = ""+ job[keys_map['type_'+kind]]
		except:
			pass
		try:
			link += job[keys_map['link_'+kind]]
		except:
			pass
		#
		# if kind == 'jooble':
		# 	div_class = 'jdp-body-vacancy-style'
		# elif kind == 'adzuna' :
		# 	div_class = 'job_details_body'

		resp = urlrequest.urlopen(link)
		html_page = resp.read().decode('utf-8')
		soup = BeautifulSoup(html_page, 'html.parser')
		all_divs = soup.find_all("div")
		content = set()
		wrong_start = ["Desktop View","About Jooble","Mobile View","DVF Recruitment","More infoAccept","Login","Go to",
					   "Additional Mobile","Find jobList","We use cookies"]
		wrong_end = ["days ago",]

		for div in all_divs:
			div_content = div.text.strip().replace("Partnership For ATSFor Job BoardsFor Publishers","").strip()
			start = " ".join(div_content.split()[:2])
			end = " ".join(div_content.split()[-2:])
			if not start in wrong_start and not end in wrong_end and "We use cookies" not in div_content \
					and not len(div_content.split())<7:
				if len(div_content.split())<11 and ("Desktop View" in div_content or "LoginFind" in div_content or "Go to" in div_content or "Login" in div_content) :
					continue

				content.add(div_content)

		content_list = list(content)
		description += " ".join(content_list)
		# for item in content_list :
		# 	print(item)
		# break
		# divs = soup.find_all("div", {"class": ''+div_class})
		# description = ''
		# for t in soup:
		# 	#if t.parent.name not in blacklist:
		# 	description += t.extract().replace('\n', ' ')
		# if not divs :
		# 	actal_page_links = ''
		# 	for lin in soup.find_all('link'):
		# 		actal_page_links = lin.get('href')
		# 		link = actal_page_links
		# 		break
		#
		# 	try:
		# 		## Attempt again the fetching
		# 		resp = urlrequest.urlopen(actal_page_links)
		# 		soup2 = BeautifulSoup(resp.read().decode('utf-8'), 'html.parser')
		#
		# 		search_text = max(" ".join(description.split(" ")[:-1]).split('.'),key=len).strip()
		# 		search_text = " ".join(" ".join(search_text.split()).split(',')[-1].split(' ')[-4:])
		# 		divs = soup2.find_all('div')
		#
		# 		if not divs:
		# 			try:
		# 				divs = soup2.find(text=re.compile(search_text)).parent
		# 			except:
		# 				pass
		#
		# 			for div in divs:
		# 				inter = div.extract().replace('\n', ' ')
		# 				description += '\n' + " ".join(inter.strip().split())
		# 		else:
		# 			for div in divs:
		# 				children = div.findChildren("div", recursive=False)
		# 				if not children:
		# 					inter = ''
		# 					try:
		# 						inter = div.text.strip()
		# 					except:
		# 						pass
		# 					try:
		# 						if inter:
		# 							description = description + '. ' + " ".join(inter.strip().split())
		# 					except:
		# 						pass
		# 				else:
		# 					for child in children :
		# 						inter = ''
		# 						try:
		# 							inter = child.text.strip()
		# 						except:
		# 							pass
		# 						try:
		# 							if inter:
		# 								description = description + '. ' + " ".join(inter.strip().split())
		# 						except:
		# 							pass
		# 	except:
		# 		pass
		# else:
		# 	for div in divs:
		# 		children = div.findChildren("div" , recursive=False)
		# 		inter = ''
		# 		if not children:
		# 			try:
		# 				inter = div.text.strip()
		# 			except:
		# 				pass
		# 		else:
		# 			try:
		# 				inter = div.text.strip()
		# 			except:
		# 				pass
		#
		# print('Description : ', description, '\n\n')

		#clean up the description
		description = description.replace('"',' ')
		description = description.replace('{', '')
		description = description.replace('}', '')
		description = description.replace("'", " ")
		description = description.replace('...',' ')
		description = description.replace('&nbsp;',' ')
		description = ". ".join(description.rstrip().split('\n'))
		description = ". ".join(description.rstrip().split('\r\n'))
		description = ". ".join(description.rstrip().split('\r'))
		description = description.replace('\t', ' ')
		description = re.sub('<[^<]+?>', '', description)

		print('Description : ',description,'\n\n')

		job_post_string_ = """{
				"jobPost": [
				{
				 "title": " """+re.sub('<[^<]+?>', '', str(title))+""" ", 
				 "id" : " """+str(id)+""" ", 
				 "location": " """+str(location)+""" ", 
				 "company": " """+str(company)+""" ",
				 "description": " """+re.sub('<[^<]+?>', '', str(description))+""" ",
				 "salary": " """+str(salary)+""" ", 
				 "type": " """+str(type)+""" ",
				 "link": " """+str(link)+""" ",
				 "date": " """+str(date)+""" "
				 } 
			]
		}"""

		dobie_str = """{
					"tasks":[
					{
					"label":" """+str(id)+""" ", 
					"jobDescription":" """+description+""" "
					}
				]
			}"""

		try:
			jop_post_json = json.loads(job_post_string_)
			dobie_request = json.loads(dobie_str)
		except:
			continue

		# CHECK DUPLICATES
		if not is_duplicate(id,date,company,location,title,description,salary,type,link,kind):
			jobpost_json_string = json.dumps(jop_post_json)
			dobie_request = json.dumps(dobie_request)

			#CALL DOBIE SERVICE
			#dobie_url = "https://demo.iais.fraunhofer.de/dobie/"
			# dobie_url="https://user:5UxLtwaeJ8fK@demo.iais.fraunhofer.de/dobie/fileUpload/jobWatch"
			dobie_url="https://user:5UxLtwaeJ8fK@demo.iais.fraunhofer.de/dobie/jsonData/jobPostNTUA"

			# files = {'file': jobpost_json_string}
			# r = requests.post(dobie_url, files=files,verify=False)

			headers = {'Content-type': 'application/json', 'Accept': 'text/text'}
			try:
				r = requests.post(dobie_url, data=dobie_request, verify=False)


			# r = requests.post(dobie_url, data=jop_post_json, headers=headers, verify=False,
			# 				  auth=HTTPBasicAuth('user', '5UxLtwaeJ8fK'))

			annotations = r.text
			print("\n\n Annotations : \t", r.status_code,"\n",annotations)

			#SAVE THE OUTPUT
			file_name = "outputs/"+kind+"-"+datetime.today().strftime('%Y-%m-%d')+"-"+id+".ttl"
			save_to_file(file_name,annotations)

## TO BE USED WITH INDEED
# indeedClient = IndeedClient(publisher = YOUR_PUBLISHER_NUMBER)
# class JobPostRequest:
#     def __init__(self, host, headers, host_user, key, body):
#         self.host = host
#         self.headers = headers
#         self.user = host_user
#         self.key = key
#         self.body = body
#
#         def simple_get(url):
#             """
#             Attempts to get the content at `url` by making an HTTP GET request.
#             If the content-type of response is some kind of HTML/XML, return the
#             text content, otherwise return None.
#             """
#             try:
#                 with closing(get(url, stream=True)) as resp:
#                     if is_good_response(resp):
#                         return resp.content
#                     else:
#                         return None
#
#             except RequestException as e:
#                 log_error('Error during requests to {0} : {1}'.format(url, str(e)))
#                 return None
#
#         def is_good_response(resp):
#             """
#             Returns True if the response seems to be HTML, False otherwise.
#             """
#             content_type = resp.headers['Content-Type'].lower()
#             return (resp.status_code == 200
#                     and content_type is not None
#                     and content_type.find('html') > -1)
#
#         def log_error(e):
#             """
#             It is always a good idea to log errors.
#             This function just prints them, but you can
#             make it do anything.
#             """
#             print(e)
#
#     def httpRequest(self):
#         connection = hc.HTTPConnection(host)
#         connection.request('POST', '/api/' + key, body, headers)
#         response = connection.getresponse()
#
#         return response

# # JOOBLE REQUEST
# #request headers
# headers = {"Content-type": "application/json"}
# #json query
# body = '{ "keywords": "it", "location": "Bern"}'
# host = 'jooble.org'
# key = 'Cccf4355f-e842-4276-9ca2-5be5f9475118'
#
# joobleRequest = JobPostRequest(host,headers,'',key,body)
# response = joobleRequest.httpRequest()
# print(response.status, response.reason)
# print(response.read())


#######################################################################################################################
## Copy the SEAS repo to qualichain
## Alfresco create a folder under the deliverable implementation .....
## Write how to run the code ETC
##
## Deliverable 5.3
##
## 30th September - 1st October 2020  PLenary, Qualichain
#######################################################################################################################

if __name__ == "__main__":

	WAIT_SECONDS = 86400

	runs_dict = {''}

	def yield_posts(sector):
		for country in ACCEPTED_COUNTRIES:
			print('Size Sector : ', len(sector))
			print(sector)
			for keywords in sector:  # "Computer programming" #
				# START WITH JOOBLE
				host = 'jooble.org'
				connection = http.client.HTTPSConnection(host)
				# request headers
				headers = {"Content-type": "application/json"}
				# key = 'ccf4355f-e842-4276-9ca2-5be5f9475118'
				key = '3b1979cd-44f0-4bd2-abca-33e493acd4a7'

				### WE DO THIS CALL 4 TIMES TO AVOID A THIRD LOOP
				body = '{ "keywords": "'+keywords+'", "location":"'+country+'","page":1}'
				connection.request('POST', '/api/' + key, body, headers)
				response = connection.getresponse()
				response_str = response.read()
				results = json.loads(response_str.decode('utf-8'))['jobs']

				body = '{ "keywords": "' + keywords + '", "location":"' + country + '","page":2}'
				connection.request('POST', '/api/' + key, body, headers)
				response = connection.getresponse()
				response_str = response.read()
				results.extend(json.loads(response_str.decode('utf-8'))['jobs'])

				body = '{ "keywords": "' + keywords + '", "location":"' + country + '","page":3}'
				connection.request('POST', '/api/' + key, body, headers)
				response = connection.getresponse()
				response_str = response.read()
				results.extend(json.loads(response_str.decode('utf-8'))['jobs'])

				body = '{ "keywords": "' + keywords + '", "location":"' + country + '","page":4}'
				connection.request('POST', '/api/' + key, body, headers)
				response = connection.getresponse()
				response_str = response.read()
				results.extend(json.loads(response_str.decode('utf-8'))['jobs'])

				print('Size of Results : ', len(results))
				process_reslts(results, connection, 'jooble')

		# Change to ADZUNA
		# for city in CITIES:
		# 	try:
		# 		print('\n ========= Adzuna ========= \n')
		# 		req = requests.get(
		# 			'https://api.adzuna.com/v1/api/jobs/'+country_mapping[city[1].strip()]+'/search/1?app_id=d259fd56&app_key=ce757054399cfabd932b10f768dab293'
		# 			'&results_per_page=1000&what_or='+keywords+'&where='+city[0].strip())
		# 		results = json.loads(req.text)['results']
		# 		print(results)
		# 		process_reslts(results, connection, 'adzuna')
		# 	except:
		# 		print("Unexpected error:", sys.exc_info()[0])
		# 		raise



		#threading.Timer(WAIT_SECONDS, yield_posts).start()
	print(titles)
	schedule.every().saturday.at('09:45').do(yield_posts,sectors[titles[0]])
	schedule.every().tuesday.at('23:36').do(yield_posts,sectors[titles[2]])
	schedule.every().wednesday.at('20:23').do(yield_posts,sectors[titles[2]])
	schedule.every().thursday.at('00:10').do(yield_posts,sectors[titles[2]])
	schedule.every().friday.at('09:35').do(yield_posts,sectors[titles[4]])
	schedule.every().monday.at('23:44').do(yield_posts,sectors[titles[0]])


	while True:
		schedule.run_pending()
		time.sleep(2)
	#yield_posts()
## username and password
## https://user:5UxLtwaeJ8fK@demo.iais.fraunhofer.de/dobie/
## Opentapioca-DBLP:journals/corr/abs-1904-09131
#https://api.adzuna.com/v1/api/jobs/de/search/1?app_id=d259fd56&app_key=ce757054399cfabd932b10f768dab293&results_per_page=1000&what_or=state vet senior specialist physiotherapist disaster preparedness coordinator charity coordinator&where=Berlin
#https://api.adzuna.com/v1/api/jobs/de/search/1?app_id=d259fd56&app_key=ce757054399cfabd932b10f768dab293&results_per_page=1000&what_or=  ICT quality manager ICT scientist application developer data base developer IT compatibility tester data warehouse analyst information security manager data manager ICT security chief IT research advisor app coder ICT sysadmins system configurators database programmer software application configurator ICT sustainability systems consultant ICT security advisor numerical process control tool setting operator numerical tool maker application tester network support designer of intelligent systems sysadmin system setup professional database developers chief ICT security officers ICT auditor managers ICT system analysts data engineer application designer IT science researcher system analyst data storage analyst intelligent system designer ICT resilience managers application software developers accessibility designer ICT capability manager embedded systems software developers ICT systems developers database design engineer AI system designer chief information security officer system configuration professional network analyst data warehouse developer programmer analyst lead IT business analyst intelligent systems engineer information systems architect numerical tool setter green IT consultant IT system analyst manager for disaster recovery UI programmer ICT science researcher information communications technology security consultant application integration consultant system security administrator system and networks administrator ICT integration engineers UI developers cyber forensics expert ICT resilience analysts embedded systems developer software integration engineer data scientists solution architect software specialist ICT security tester knowledge officer applications engineer enterprise designer software requirement analyst data base designer security coordinator digital game tester unit tester ICT systems developer software programmer IT capacity planner numerical tool l programme setter user experience analysts ICT research specialist digital forensics experts application programmer software application tester solutions developer linked data engineer semantic technologies engineer software analysts research data scientist IT research consultant web application developer ICT technical security expert data base integrators numerical process control  set up operator ICT security administrators UI designer system security tester database architect usability specialist database development specialist IT systems analyst digital game developer search engine optimisation consultant accessibility test specialist database development engineer data integrity specialist network developer app programmer usability developer digital games testers systems integration consultants UI developer fead of IT security computer scientist digital forensics specialist ICT systems architect networks engineer IT commercial analysis manager numerical tool machine set up operator ICT security consultants data administrator ICT environmental consultant test designer IT audit manager information forensics expert network security administrator IT security expert IT system administrator data integrity officer enterprise architects virtual games tester ICT auditor IT security manager module integration tester IT research scientist network specialist head IT security officer systems configurator artificial intelligence designer ICT test manager ICT audit manager web content curatorspecialist embedded systems programmer systems integration consultant enterprise architecture manager information technology auditor IT consultant usability analyst system integration engineer IT security chief ICT research advisor manager for vulnerability user experience officer ICT quality assurance managers search engine optimiser data quality specialists usability testers accessibility testers ICT forensics expert search engine optimisation experts integration testers server administrator ICT researcher front end developer digital content network administrators tester system developer content curator principal test manager IT Quality Appraiser user interface developers digital forensics analyst ICT consultants data expert disaster recovery officer systems developer numerical process control operator ICT system developers ICT performance manager data quality officer computer forensics investigator business continuity strategist computers scientist embedded system programmer vulnerability analyst module tester systems analyst business continuity analyst IT system tester embedded system developer vulnerability manager handheld programmer data research scientist search engine optimisation specialist embedded systems designer application software tester ICT systems administrator programmer IT security administrator system software developer soft tester information technology audit manager app software developer information engineer network security tester computer forensics expert data base administrators data quality expert systems programmer user-friendliness tester application configurators database integrators developer of software app developer enterprise administrator network configurator usability tester web engineer ethical hackers IT security consultant machine learning systems designer IT systems administrator information technology security consultant system and network administrator software designer linked data engineer, intelligent systems developer network designer software engineer ICT system administrators industrial mobile devices software coder IT integration engineer CISO user interface engineer application architect application analyst mobile app developer application software engineer embedded systems designers digital forensic expert ICT research consultants growth hacker virtual games developer application software configurator networks administrator soft developer data integrator IT business analyst ICT sysadmin ICT systems administrators software architects web programmer compatibility tester IT researcher data base integrator application software developer numerical tool machine operator web developers industrial mobile devices software programmer embedded system software programmer ICT system configurator IT resilience analyst consultant in ICT security activities ICT advisor search engine marketing specialist DBA ICT security managers web content administrators knowledge engineers software developers IT system configurator ICT system architects SEO experts IT disaster recovery analyst video games tester inbound marketer data warehouse architect ICT business analysis managers IT business analysis director ICT capacity planners ICT systems analysts data analysts ICT research scientist ICT business analysts network administrator network manager web specialist IT security advisor ICT ERP consultant module compatibility tester network architects analyst of software disaster recovery manager app configurator embedded software developer IT quality assurance manager numerical process control programmer IT capability planner software testers database configurator content specialist video games developer ICT systems architects business process specialist intelligent systems designers IT system developer data architect programming analyst ICT systems tester ICT systems analyst systems architect networks designer numerical process control supervisor embedded system software developer ICT principal testing manager software requirements analyst enterprise developer SEO expert data base designers numerical tool setting operator database administrators networks developer ICT commercial analysis manager IT systems architect chief ICT system developer handheld software developer computer games tester green ICT consultants IT research specialist database manager web content specialist SEO specialist data base developers manager for IT resilience IT advisor component developer embedded software developerl embedded systems engineer software testing specialist IT system architect IT test analyst ICT researchers ICT compatibility tester IT scientist games programmer digital games developers embedded software programmer data model designer mobile app specialist database designers user interface designers ICT systems test engineer ICT systems testers IT business analysis manager system integration consultants network integration consultant mobile application developers data base administrator numerical tool programmer data warehousing analyst IT resilience manager IT environmental consultant computer games developer taxonomist database coder database design specialist systems tester network engineers machine manufacture industry models information technology computer deep learnig deeplearning programming algorithm innovation database software software engineering software engineer physics maths informatics cloud computing analyst analysis data analysis technology devops big data data science bigdata &where=Berlin
# https://api.adzuna.com/v1/api/jobs/de/search/1?app_id=d259fd56&app_key=ce757054399cfabd932b10f768dab293&results_per_page=1000&what_or=search engine optimiser&where=Berlin


# # # ADZUNA
#host = 'jooble.org'
# connection = http.client.HTTPSConnection(host)
# var unirest = require("unirest");
# var req = unirest("GET", "https://baskarm28-adzuna-v1.p.rapidapi.com/jobs/%257Bcountry%257D/search/%257Bpage%257D");
# adzuna_host = 'https://baskarm28-adzuna-v1.p.rapidapi.com/jobs/%257Bcountry%257D/search/%257Bpage%257D'
# YOUR_APP_ID = '4cda1a47'
# YOUR_APP_KEY = '9ab420a727b9b130cb8496b9774050b4'
# adzuna_host = 'api.adzuna.com'
# connection = http.client.HTTPSConnection(adzuna_host)		#adzuna_host
# page_number = 1
# # while page_number < 5:


# curl -v -H "Content-Type:application/json" -d "{\"tasks\":[{\"label\":\"95671c903a5b97a9\", \"jobDescription\":\"Classical cryptography: Substitution cryptosystems, Caesar, Vigenere, cryptanalysis methods. Perfect secrecy (Shannon), one-time pad. Semantic security, CPA, CCA, PCPA. Symmetric cryptography. Pseudorandomness, stream cryptosystems. Block cryptosystems: Feistel circuits, DES, AES, operation modes. Message authentication codes (MACs). Hash functions, salt, Merkle trees.Elements of number theory: divisibility, residue arithmetic, quadratic residues, Chinese remainder theorem. Elements of group theory: groups, rings, Legendre theorem. Euler's φ function. Prime number tests. Public key cryptography. RSA and Rabin cryptosystems, relation to factoring problem. The discrete logarithm problem, ElGamal cryptosystem. Diffie-Hellman key exchange. Digital signatures: RSA, DSS, blind signatures. Cryptographic protocols: secret sharing, zero knowledge proofs, identification. Elements of complexity theory: one-way functions. Applications: encrypted communications, electronic voting, attacks, crypto-currencies (bitcoin).The course contains (in addition to exercises) a project with a written report and presentation, linear programming, computer science, Computer Science, flask, mongodb, angularjs, angular.js, ravendb, rdbms, .net, c++, html5, autosar, jenkins, junit, websocket\"}]}" "https://demo.iais.fraunhofer.de/dobie/jsonData/jobPostNTUA"
# Thanks. Will try this in the course of the day