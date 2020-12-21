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
ACCEPTED_COUNTRIES = ['united kingdom' ,'ireland'] # ,'germany', 'france'] #, 'united states', 'canada', 'germany', 'france',
country_mapping = {'united kingdom': 'gb', 'germany':'de','united states': 'us', 'canada': 'ca', 'france': 'fr',
				   'ireland': 'ie','Switzerland':'ch'}

with open('lists/world-cities.csv', 'rt')as f:
	data = csv.reader(f)
	for row in data:
		if row[1].strip().lower() in ACCEPTED_COUNTRIES:
			CITIES.append([row[0].lower(),row[1].lower()])

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
			data_list.extend([r.strip() for r in row.split(' ') ])
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
	                    " WHERE `id` LIKE '%"+id.strip()+"%' company LIKE '"+company.strip()+"'" \
						" AND title LIKE '%"+title.strip()+"%' AND link LIKE '%"+link.strip()+"%'; "

	con = lite.connect(db_file)

	with con:
		cur = con.cursor()
		cur.execute(select_query)
		data = cur.fetchall()

	if data :
		#print('Already Exists')
		return True
	else:
		# UPDATE QUERY
		insert_query = "INSERT INTO "+table+"(id, post_date, company, location, title, description, salary, type, link) " \
						"VALUES('"+id.strip()+"', '"+date.strip()+"', '"+company.strip()+"', '"+location.strip()+"'," \
						" '"+title.strip()+"', '"+description.strip()+"', '"+salary.strip()+"', '"+type+"', '"+link.strip()+"');"
		try:
			with con:
				print(date)
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
		for line in of:
			of.write(line+"\n")
	of.close()

# Skip through each job and fetch page contents
def process_reslts(results, connection, kind='jooble'):
	for job in results:

		time.sleep(30)

		# Skip through each job and fetch page contents
		title = ""+ str(job['title'])
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

		if kind == 'jooble':
			div_class = 'jdp-body-vacancy-style'
		elif kind == 'adzuna' :
			div_class = 'job_details_body'

		#resp = requests.get(link)
		resp = urlrequest.urlopen(link)
		soup = BeautifulSoup(resp.read(), 'html.parser')
		divs = soup.find_all("div", {"class": 'job_details_body'})
		if not divs :
			actal_page_links = ''
			for lin in soup.find_all('link'):
				actal_page_links = lin.get('href')
				link = actal_page_links
				break

			soup2 = BeautifulSoup('', 'html.parser')
			divs = []
			search_text = " "
			try:
				## Attempt again the fetching
				resp = urlrequest.urlopen(actal_page_links)
				soup2 = BeautifulSoup(resp.read().decode('utf-8'), 'html.parser')

				search_text = max(" ".join(description.split(" ")[:-1]).split('.'),key=len).strip()
				search_text = " ".join(" ".join(search_text.split()).split(',')[-1].split(' ')[-4:])
				divs = soup2.find_all('div')
			except:
				pass

		if not divs:
			try:
				divs = soup2.find(text=re.compile(search_text)).parent
			except:
				pass

			for div in divs:
				inter = div.extract().replace('\n',' ')
				description += '\n'+" ".join(inter.strip().split())
		else:

			for div in divs:
				children = div.findChildren("div" , recursive=False)

				if not children:
					inter=''
					try:
						inter = div.text.strip()
					except:
						pass
					try:
						if inter:
							description = description+'. '+" ".join(inter.strip().split())
					except:
						pass

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
		description = description.replace('<b>','').replace('</b>','')
		description = description.replace('\t', ' ')

		job_post_string_ = """{
				"jobPost": [
				{
				 "title": " """+str(title)+""" ", 
				 "id" : " """+str(id)+""" ", 
				 "location": " """+str(location)+""" ", 
				 "company": " """+str(company)+""" ",
				 "description": " """+str(description)+""" ",
				 "salary": " """+str(salary)+""" ", 
				 "type": " """+str(type)+""" ",
				 "link": " """+str(link)+""" ",
				 "date": " """+str(date)+""" "
				 } 
			]
		}"""

		try:
			jop_post_json = json.loads(job_post_string_)
		except:
			continue

		# CHECK DUPLICATES
		if not is_duplicate(id,date,company,location,title,description,salary,type,link,kind):
			#CALL DOBIE SERVICE
			#dobie_url = "https://demo.iais.fraunhofer.de/dobie/"
			dobie_url="https://user:5UxLtwaeJ8fK@demo.iais.fraunhofer.de/dobie/fileUpload/jobWatch"
			jobpost_json_string = json.dumps(jop_post_json)

			files = {'file': jobpost_json_string}
			try:
				r = requests.post(dobie_url, files=files,verify=False)
				annotations = r.text

				#SAVE THE OUTPUT
				file_name = "outputs/"+kind+"-"+datetime.today().strftime('%Y-%m-%d')+"-"+id+".ttl"
				save_to_file(file_name,annotations)

			except:
				continue
			finally:
				pass

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
		covered_countries = []
		for city in CITIES:
			# client = IndeedClient(publisher = YOUR_PUBLISHER_NUMBER)
			if city[1].strip() not in covered_countries :  # BECAUSE IN JOOBLE, THE JOBS ARE GIVEN PER COUNTRY
				page_number = 1
				while page_number<4:
					host = 'jooble.org'
					connection = http.client.HTTPSConnection(host)
					# request headers
					headers = {"Content-type": "application/json"}
					#key = 'Cccf4355f-e842-4276-9ca2-5be5f9475118'
					key = '3b1979cd-44f0-4bd2-abca-33e493acd4a7'
					keywords = ", ".join(sector[:10])
					print(keywords)
					#body = '{ "keywords": '+keywords+', "location":"'+city[1].strip()+'","page":'+str(page_number)+'}'
					body = '{ "keywords": computer, "location":"'+city[1].strip()+'","page":'+str(page_number)+'}'
					connection.request('POST', '/api/' + key, body, headers)
					response = connection.getresponse()
					response_str = response.read()
					print(response_str)
					results = json.loads(response_str.decode('utf-8'))['jobs']
					process_reslts(results, connection, 'jooble')
					covered_countries.append(city[1].strip())
			#
			# 		page_number += 1
			#
			# # ADZUNA

			#host = 'jooble.org'

			# connection = http.client.HTTPSConnection(host)

			# var unirest = require("unirest");
			# var req = unirest("GET", "https://baskarm28-adzuna-v1.p.rapidapi.com/jobs/%257Bcountry%257D/search/%257Bpage%257D");
			adzuna_host = 'https://baskarm28-adzuna-v1.p.rapidapi.com/jobs/%257Bcountry%257D/search/%257Bpage%257D'
			YOUR_APP_ID = '4cda1a47'
			YOUR_APP_KEY = '9ab420a727b9b130cb8496b9774050b4'
			adzuna_host = 'api.adzuna.com'
			connection = http.client.HTTPSConnection()		#adzuna_host
			page_number = 1
			# while page_number < 5:

			try:
				#print("Current City : ",country_mapping[city[1].strip()])
				keywords = " ".join(sector) #"Computer programming" #
				print('\n\n ========= Adzuna ========= \n\n')
				print("\n\n",keywords,"\n\n")
				req = requests.get(
					'https://api.adzuna.com/v1/api/jobs/'+country_mapping[city[1].strip()]+'/search/1?app_id=d259fd56&app_key=ce757054399cfabd932b10f768dab293'
					'&results_per_page=1000&what_or='+keywords+'&where='+city[0].strip())
				results = json.loads(req.text)['results']
				print(results)
				process_reslts(results, connection, 'adzuna')
			except:
				print("Unexpected error:", sys.exc_info()[0])
				raise

		#threading.Timer(WAIT_SECONDS, yield_posts).start()
	print(titles)
	schedule.every().saturday.at('09:45').do(yield_posts,sectors[titles[0]])
	schedule.every().tuesday.at('01:00').do(yield_posts,sectors[titles[1]])
	schedule.every().wednesday.at('01:00').do(yield_posts,sectors[titles[2]])
	schedule.every().thursday.at('09:13').do(yield_posts,sectors[titles[0]])
	print("\n\n",titles[-2],"\n\n")
	schedule.every().friday.at('14:09').do(yield_posts,sectors[titles[3]])
	schedule.every().monday.at('21:22').do(yield_posts,sectors[titles[2]])


	while True:
		schedule.run_pending()
		time.sleep(10)
	#yield_posts()
## username and password
## https://user:5UxLtwaeJ8fK@demo.iais.fraunhofer.de/dobie/
## Opentapioca-DBLP:journals/corr/abs-1904-09131
https://api.adzuna.com/v1/api/jobs/de/search/1?app_id=d259fd56&app_key=ce757054399cfabd932b10f768dab293&results_per_page=1000&what_or=state vet senior specialist physiotherapist disaster preparedness coordinator charity coordinator&where=Berlin