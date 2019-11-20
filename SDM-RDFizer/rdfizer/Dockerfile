# Use an official Python runtime as a parent image
FROM ubuntu:18.10

# Install any needed packages specified in requirements.txt
RUN apt-get update
RUN apt-get install -y python3 python3-pip python3-psycopg2 python3-mysqldb
#RUN apt-get install -y python3-pip libpq-dev mysql-client libmysqlclient-dev python3-dev #python-dev

# Set the working directory to /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD . /app

RUN pip3 install --trusted-host pypi.python.org -r requirements.txt

# Make port 80 available to the world outside this container
EXPOSE 80

# Define environment variable
ENV NAME RDFizer

# Run app.py when the container launches
CMD ["python3", "/app/app.py"]