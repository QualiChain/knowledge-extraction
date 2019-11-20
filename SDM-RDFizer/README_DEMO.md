# Demo

To test SDM-RDFizer, first build the container in the rdfizer folder:

```bash
cd rdfizer
docker build -t rdfizer .
```

Then start a container and connect to it:

```bash
docker run -d -v `pwd`/demo:/demo -p 8080:80 --name c_rdfizer rdfizer 
```

You should be able to produce an output in testoutput.csv by either running 
rdfizer directly in a shell like this:

```bash
docker exec -i -t c_rdfizer /bin/bash
cd /app
python3 /app/run_rdfizer.py /demo/configfile.ini
exit
```

or by duing a post request with the config file to localhost:8080
```bash
curl -X POST localhost:8080/graph_creation/demo/configfile.ini
``` 
(On MacOSX or Windows hosts one may need to change "localhost" to the ip of the docker host network.)

You should then find the file testoutput_datasets_stats.cvs together with various other results in the 
output folder in the demo folder.