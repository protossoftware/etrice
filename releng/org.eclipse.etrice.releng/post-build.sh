echo 'promoting to download area...'
echo 'deleting directories'
rm -Rf /home/data/httpd/download.eclipse.org/etrice/updates/nightly/*
rm -Rf /home/data/httpd/download.eclipse.org/etrice/archives/nightly/zips/*
echo 'copy update site'
cp -R ${WORKSPACE}/last_success/site.packed/* /home/data/httpd/download.eclipse.org/etrice/updates/nightly/
echo 'copy zips'
cp -R ${WORKSPACE}/last_success/site.p2.zip/* /home/data/httpd/download.eclipse.org/etrice/archives/nightly/zips/
cp -R ${WORKSPACE}/last_success/deliveries /home/data/httpd/download.eclipse.org/etrice/archives/nightly/zips/
echo 'done'
