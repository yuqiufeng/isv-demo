#!/bin/bash

CURRENT_DIR=`dirname $0`
API_HOME=`cd "$CURRENT_DIR/.." >/dev/null; pwd`
Jar=`ls $API_HOME/lib/demo-1.0.0-*.jar`
RETVAL="0"
LOG="api_stdout.log"

# run java application
cd $API_HOME
java -jar $Jar >> $API_HOME/logs/$LOG 2>&1


