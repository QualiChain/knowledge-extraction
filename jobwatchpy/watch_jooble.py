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
from os import path
import os
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

# Function to Check Week Number in the Month
def week_of_month():
    day_of_month = datetime.now().day
    week_number = (day_of_month - 1) // 7 + 1
    return week_number

# Function to check duplicates
def is_duplicate(id,date,company,location,title,description,salary,type,link,table):
	db_file = "db/jobposts"

	# SELECT QUERY
	select_query = "SELECT id, title FROM "+table+ \
	                    " WHERE `id` LIKE '%"+id.strip()+"%' AND `title` LIKE '%"+title.strip()+"%'; "

	con = lite.connect(db_file)
	data = ''
	try:
		with con:
			cur = con.cursor()
			cur.execute(select_query)
			data = cur.fetchall()
	except :
		# print('There was an Error when checking for existance of post',e)
		# print(select_query,'\n\n')
		# return True
		data = 'Error'
		pass

	if data :
		#print("\n Data here is : ",data)
		return True
	else:
		# UPDATE QUERY
		#print("\n Data here is : ", data)
		insert_query = "INSERT INTO "+table+"(id, post_date, company, location, title, description, salary, type, link) " \
						"VALUES('"+id.strip()+"', '"+date.strip()+"', '"+company.strip()+"', '"+location.strip()+"'," \
						" '"+title.strip()+"', '"+description.strip()+"', '"+salary.strip()+"', '"+type+"', '"+link.strip()+"');"
		try:
			with con:
				cur = con.cursor()
				cur.execute(insert_query)
				con.commit()
		except Exception as e :
			# print('There was an Error when Inserting Post',e)
			# print(select_query,'\n\n')
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
def process_reslts(results, connection, country, sec_name, kind='jooble'):
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
		try:
			resp = urlrequest.urlopen(link)
		except:
			continue
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

		# print('Description : ',description,'\n\n')

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
					"jobDescription":" """+description+""" ",
					"title": " """+re.sub('<[^<]+?>', '', str(title))+""" ", 
					"id" : " """+str(id)+""" ", 
					"location": " """+str(location)+""" ", 
					"company": " """+str(company)+""" ",					
					"salary": " """+str(salary)+""" ", 
					"type": " """+str(type)+""" ",
					"link": " """+str(link)+""" ",
					"date": " """+str(date)+""" "
					}
				]
			}"""
		# "description": " """ + re.sub('<[^<]+?>', '', str(description)) + """ ",
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
			# dobie_url="https://user:5UxLtwaeJ8fK@demo.iais.fraunhofer.de/dobie/fileUpload/jobWatch"
			dobie_url="https://user:5UxLtwaeJ8fK@demo.iais.fraunhofer.de/dobie/jsonData/jobPostNTUA"

			# files = {'file': jobpost_json_string}
			# r = requests.post(dobie_url, files=files,verify=False)

			headers = {'Content-type': 'application/json', 'Accept': 'text/text'}
			try:
				r = requests.post(dobie_url, data=dobie_request, verify=False)

			# r = requests.post(dobie_url, data=jop_post_json, headers=headers, verify=False,
			# 				  auth=HTTPBasicAuth('user', '5UxLtwaeJ8fK'))
			except:
				continue

			annotations = r.text
			#print("\n\n Annotations : \t", r.status_code,"\n",annotations)

			prepath = os.getcwd()+"/outputs/"+kind


			if not path.exists(prepath+"/"+sec_name) :
				# CREATE THE COUNTRY FOLDER
				try:
					os.mkdir(prepath+"/"+sec_name)
				except OSError:
					print("Creation of the directory %s failed" % prepath)
					continue

			prepath = prepath + "/" + sec_name


			# print("The Working Directory is : ",os.getcwd())

			# CHECK EXISTANCE OF WEEK FOLDER, SECTOR FOLDER AND COUNTRY
			if not path.exists(prepath+"/"+country) :
				# CREATE THE COUNTRY FOLDER
				try:
					os.mkdir(prepath+"/"+country)
				except OSError:
					print("Creation of the directory %s failed" % prepath)
					continue

			prepath = prepath + "/" + country

			# MONTH
			mydate = datetime.now()
			month=mydate.strftime("%b")
			# CHECK THE WEEK NUMBER
			if not path.exists(prepath + "/" +month+"-Week" + str(week_of_month())):
				# CREATE THE WEEK FOLDER
				try:
					os.mkdir(prepath + "/" +month+"-Week" + str(week_of_month()))
				except OSError:
					print("Creation of the directory %s failed" % prepath)
					continue

			prepath = prepath + "/" +month+"-Week" + str(week_of_month())

			#SAVE THE OUTPUT
			file_name = prepath+"/"+kind+"-"+datetime.today().strftime('%Y-%m-%d')+"-"+id+".ttl"
			save_to_file(file_name,annotations)

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

	def yield_posts(sector,secNum):
		for country in ACCEPTED_COUNTRIES:
			# print('Size Sector : ', len(sector))
			# print(sector)
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

				process_reslts(results, connection, country, titles[secNum], 'jooble')

	schedule.every().sunday.at('13:00').do(yield_posts,sectors[titles[4]],4)
	schedule.every().tuesday.at('13:00').do(yield_posts,sectors[titles[5]],5)
	schedule.every().wednesday.at('13:00').do(yield_posts,sectors[titles[0]],0)
	schedule.every().thursday.at('13:00').do(yield_posts,sectors[titles[3]],3)
	schedule.every().friday.at('13:00').do(yield_posts,sectors[titles[2]],2)
	schedule.every().monday.at('13:30').do(yield_posts,sectors[titles[1]],1)
	schedule.every().sunday.at('13:00').do(yield_posts, sectors[titles[0]],0)

	while True:
		schedule.run_pending()
		time.sleep(2)