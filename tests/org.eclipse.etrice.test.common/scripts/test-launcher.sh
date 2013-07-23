###############################################################################
# Copyright (c) 2012 protos software gmbh (http://www.protos.de).
# All rights reserved. This program and the accompanying materials
# are made available under the terms of the Eclipse Public License v1.0
# which accompanies this distribution, and is available at
# http://www.eclipse.org/legal/epl-v10.html
#
# CONTRIBUTORS:
# 		Thomas Schuetz (initial contribution)
#
###############################################################################

#!/bin/sh

TESTNAME="noname"
RESULTFILE="noname.xml"


##############################
#          logging
##############################

# $1=message
function etLogger_logInfo {
	echo "INFO (test-launcher): $1"
}

# $1=message
function etLogger_logWarning {
	echo "* WARNING (test-launcher): $1"
}

# $1=message
function etLogger_logError {
	echo "*** ERROR (test-launcher): $1"
}



##############################
# helpers for writing junit test report
##############################

# arguments $1 = name of testsuite
function openTestSuite { 
	TESTNAME="$1"
	RESULTFILE="$1.xml"
	echo "<testsuite name=\"$1\">" > $RESULTFILE 
}
function closeTestSuite { 
	echo "</testsuite>" >> $RESULTFILE 
}

# arguments: $1=testcase name, $2=result (true or false), $3=message (only needed for result=false)
function writeTestCase { 
	if $2 ; then
		echo -e "\t<testcase name=\"$1\"/>" >> $RESULTFILE 
		etLogger_logInfo "testcase $1 OK"
	else
		echo -e "\t<testcase name=\"$1\">" >> $RESULTFILE 
		echo -e "\t\t<failure>$3</failure>" >> $RESULTFILE 
		echo -e "\t</testcase>" >> $RESULTFILE 
		etLogger_logError "testcase $1 FAILURE: $3"
	fi
}

##############################
# execution of all testcases
##############################

#global array to pass tokenized line between functions 
declare -a LINE_TOKENS

# $1=number of arguments, LINE_TOKENS is global array with arguments
function executeOneTest {
	#check if executable test file exists
	EXECUTABLE=./${LINE_TOKENS[0]}
	if [ -e $EXECUTABLE ] ; then
		#execute test file
		$EXECUTABLE
	else
		writeTestCase "execute $EXECUTABLE" false "file $EXECUTABLE does not exist"
		return
	fi
	
	for ((i=1; i<$1; i+=2)); do
		logfile=${LINE_TOKENS[$i]}
		expected_hits=${LINE_TOKENS[$i+1]}
		#check if logfile exists
		if [ -e $logfile ] ; then
			#everything ok -> nothing to do
			etLogger_logInfo "logfile $logfile exists -> checking for testcases"
		else
			writeTestCase "logfile $logfile" false "file $logfile does not exist"
			return
		fi

		actual_hits=`grep -c "<testcase" $logfile`
		if (( $actual_hits == $expected_hits )); then
			writeTestCase "Check $logfile" true
			etLogger_logInfo "check OK: logfile $logfile contains $actual_hits testcases"
		else
			writeTestCase "Check $logfile" false "logfile $logfile should contain $expected_hits testcases but contains $actual_hits testcases"
		fi
	done
}

function executeAllTests {
	# redirect read
	exec 10<&0
	exec < "$TESTNAME.config"
	
	while read LINE; do
		etLogger_logInfo "parsing line: $LINE"
		counter=0
		#parse tokens from line to array
		for word in $LINE; do
			LINE_TOKENS[$counter]=$word
			let counter++
		done

		if (($counter > 0)); then
			#line is not empty
			if (($counter % 2 != 1)); then
				writeTestCase "CheckCounter" false "ERROR: Line has wrong number of arguments: '$LINE', Format: test-program resultfile1 expected-testcases resultfile2  expected-testcases ..."
			else
				writeTestCase "CheckCounter for ${LINE_TOKENS[0]}" true
				executeOneTest $counter
			fi
		fi
	done
	
}



##############################
#           MAIN
##############################

# $1 = name of testcase -> $1.config is expected as config file and $1.xml contains the results in JUnit format
etLogger_logInfo "START test-launcher for test-launcher.config"
openTestSuite $1
executeAllTests
closeTestSuite
etLogger_logInfo "END test-launcher for test-launcher.config"
