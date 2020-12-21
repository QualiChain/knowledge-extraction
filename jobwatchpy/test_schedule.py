import schedule
import time

def job(t):
    print("I'm working...")
def job2(t):
    print("I am just crying out here..")
def job3(t):
    print("ANd now I am confirmed...")

schedule.every(5).seconds.do(job,20)
schedule.every(10).seconds.do(job2,10)
schedule.every(15).seconds.do(job3,5)
# schedule.every().monday.do(job)
# schedule.every().wednesday.at("13:15").do(job)
# schedule.every().minute.at(":17").do(job)

while True:
    schedule.run_pending()
    time.sleep(10)