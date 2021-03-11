# JobWatch Service

## Description
A Python version of the data acquisition service for job portals: **JobWatch**.
JobWatch is an adaptation of earlier data acquisition tools geared towards extracting semi-structured data from online job posts advertised in Job Portals. 
The earlier service was a core component in the **H2020 European Data Science Academy (EDSA)** and **QualiChain projects.**
It was also incorporated in one of the showcases of the **MINTE+ framework**.
### References
* Sibarani E.M., Scerri S. (2020) SCODIS: Job Advert-derived Time Series for high-demand Skillset Discovery and Prediction. In DEXA 2020.

* Sibarani E.M., Scerri S. (2019) Generating an Evolving Skills Network from Job Adverts for High-Demand Skillset Discovery. In Web Information Systems Engineering – WISE 2019. WISE 2020. Lecture Notes in Computer Science, vol 11881. 

* Dadzie, Aba-Sah and Sibarani, Elisa and Novalija, Inna and Scerri, Simon, Structuring Visual Exploratory Analysis of Skill Demand (March 2018). Journal of Web Semantics First Look. 

* Elisa Margareth Sibarani, Simon Scerri, Camilo Morales, Sören Auer, and Diego Collarana. 2017. Ontology-guided Job Market Demand Analysis: A Cross-Sectional Study for the Data Science field. In Proceedings of the 13th International Conference on Semantic Systems (Semantics2017). 

## Dependencies
This python version of the project depends on the following software

* TBD
* TBD

### Run
python3 watch.py > jobWatch_service.log 

or for fetching from Jooble portal alone (often Jooble is the most stable job portal API)

python3 watch_jooble.py > jobWatch_service.log &

## License

* Copyright (C) 2019 EIS Fraunhofer-IAIS
* Licensed under the Apache 2.0 License
