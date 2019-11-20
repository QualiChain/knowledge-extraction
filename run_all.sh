#!/bin/bash

TERM=xterm-color
export TERM

cd silk
sbt -Dhttp.port=9005 -Dapplication.context=/silk/ -Dparsers.text.maxLength=1024K "project workbench" run &

cd ../skill-annotation

sbt -Dhttp.port=9006 run &

cd ../data-acquisition-service

sbt run 
