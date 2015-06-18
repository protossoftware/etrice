echo 'promoting to download area...'
echo 'deleting directories'
rm -Rf /home/data/httpd/download.eclipse.org/etrice/updates/nightly/*
rm -Rf /home/data/httpd/download.eclipse.org/etrice/archives/nightly/zips/*
rm -Rf /home/data/httpd/download.eclipse.org/etrice/archives/nightly/generators
echo 'copy update site'
cp -R ${WORKSPACE}/last_success/site.packed/* /home/data/httpd/download.eclipse.org/etrice/updates/nightly/
echo 'copy zips'
cp -R ${WORKSPACE}/last_success/site.p2.zip/* /home/data/httpd/download.eclipse.org/etrice/archives/nightly/zips
mkdir /home/data/httpd/download.eclipse.org/etrice/archives/nightly/generators
cp ${WORKSPACE}/last_success/deliveries/eTrice-C-generator.zip /home/data/httpd/download.eclipse.org/etrice/archives/nightly/generators/eTrice-C-generator.zip
cp ${WORKSPACE}/last_success/deliveries/eTrice-Java-generator.zip /home/data/httpd/download.eclipse.org/etrice/archives/nightly/generators/eTrice-Java-generator.zip
echo 'done'
