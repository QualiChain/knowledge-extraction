#!flask/bin/python
from flask import Flask, jsonify
import os

app = Flask(__name__)

@app.route('/')
def index():
    return "Welcome to the Rdf Graph Service"

@app.route('/graph_creation/<path:config_file>', methods=['POST'])
def rdfgraph(config_file):
	os.system("python3 run_rdfizer.py /" + config_file)
	return "New RDF Graph has been created"

if __name__ == "__main__":
    app.run(host='0.0.0.0', port=80)