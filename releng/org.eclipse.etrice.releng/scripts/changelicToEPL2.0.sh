#!/bin/bash
# Copyright (c) 2018 - Compex Systemhaus GmbH (69115 Heidelberg, Germany) 
#                                                                           
# This program and the accompanying materials are made available under the  
# terms of the Eclipse Public License 2.0 which is available at             
# http://www.eclipse.org/legal/epl-2.0.                                     
#                                                                           
# SPDX-License-Identifier: EPL-2.0                                          
#                                                                           
# Contributors:                                                             
#      Ralf Mollik, Compex Systemhaus GmbH - initial contribution
#      Henrik Rentz-Reichert for eTrice
#                                                                          
# Migrate a project from EPL 1.0 to EPL 2.0
# This script worked fine on eTrice
#

#git pull

for f in `find . -name "*.java" -or -name "pom.xml" -or -name "plugin.xml" -or -name "*.xtext" -or -name "*.xtend" -or -name "*.xcore" -or -name "*.mwe2" -or -name "*.properties" -or -name "manifest.mf"`
do
	if [ ! -f $f ]
	then
		continue
	fi
	echo .
	echo update $f
	sed -b -i 's/Eclipse Public License v1.0/Eclipse Public License 2.0/g' $f
	sed -b -i -E '1,40s/(<!--)([[:blank:]]*[^[:blank:]])*([[:blank:]]*)http:\/\/www.eclipse.org\/legal\/epl-v10.html(.*)/\1\2\3https:\/\/www.eclipse.org\/legal\/epl-2.0\/   \4\
\1\2\3                                         \4\
\1\2\3SPDX-License-Identifier: EPL-2.0         \4/' $f
	sed -b -i -E '1,40s/([[:blank:]]*[^[:blank:]])*([[:blank:]]*)http:\/\/www.eclipse.org\/legal\/epl-v10.html(.*)/\1\2https:\/\/www.eclipse.org\/legal\/epl-2.0\/\3\
\1\3\
\1\2SPDX-License-Identifier: EPL-2.0\3/' $f
done

for f in `find . -name "epl-v10.html"`
do
	echo .
	rm $f
	newname=${f/epl-v10.html/}epl-2.0.html
	echo update $f to $newname
	curl https://www.eclipse.org/org/documents/epl-2.0/EPL-2.0.html -o $newname
	
	buildprops=${f/epl-v10.html/}build.properties
	if [ -e $buildprops ]
	then
		sed -b -i 's/epl-v10.html/epl-2.0.html/g' $buildprops
	fi
	pom=${f/epl-v10.html/}pom.xml
	if [ -e $pom ]
	then
		sed -b -i 's/epl-v10.html/epl-2.0.html/g' $pom
	fi
done

for f in `find . -name "LICENSE.txt"`
do
	echo .
	echo update $f
	curl https://www.eclipse.org/legal/epl/notice.txt  -o $f
done

for f in `find . -name "license.html" -or -name "notice.html"`
do
	echo .
	echo update $f
	curl https://www.eclipse.org/legal/epl/notice.html  -o $f
done


for f in `find . -name "about.html"`
do
	echo .
	echo update $f
	sed -b -i 's/June 5, 2006/August 17, 2018/g' $f
	sed -b -i 's/http:\/\/www.eclipse.org\/legal\/epl-v10.html/https:\/\/www.eclipse.org\/legal\/epl-2.0/g' $f
	sed -b -i 's/Eclipse Public License Version 1.0/Eclipse Public License Version 2.0/g' $f
done

for f in `find . -name "feature.properties"`
do
	echo .
	echo update $f
	grep -a -B 100000 "# \"license\" property - text of the \"Feature Update License\"" $f | grep -a -v "# \"license\" property - text of the \"Feature Update License\"" >$f.new
	curl https://www.eclipse.org/legal/epl/feature.properties.txt >>$f.new
	cp $f.new $f
	rm $f.new
done




