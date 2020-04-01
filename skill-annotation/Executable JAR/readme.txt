1. The jar file is built with Maven. download it from here and copy in this folder, next to gate directory : https://drive.google.com/open?id=1p4GpibgKzal0x05LKj7lQWEyPxgvaGHT
2. The folder "gate" contains some neccessary plugins and is a required argument for the main class.
3. In order to run the jar file, execute this command: "java -jar skill-annotation-1.0-SNAPSHOT-jar-with-dependencies "gate"
4. The server will start at localhost:5000
5. Send your file and file type with a curl request. The type of file can be either "courseDescription", "cv" or "jobPost", for example for send a course description run this:
curl -F file=@Course_Description "http://localhost:5000/dobie/fileUpload/courseDescription"
6. The server will return the extracted annotations in ttl format.