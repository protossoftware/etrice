echo 'promoting to download area...'
downloadDir=/home/data/httpd/download.eclipse.org/etrice

echo 'deleting directories'
rm -Rf $downloadDir/updates/nightly/*
rm -Rf $downloadDir/archives/nightly/zips/*
rm -Rf $downloadDir/archives/nightly/generators/*

echo 'copy update site'
cp -R ${WORKSPACE}/releng/org.eclipse.etrice.site/target/repository/* $downloadDir/updates/nightly/

echo 'copy zips'
cp ${WORKSPACE}/releng/org.eclipse.etrice.site/target/org.eclipse.etrice.site*.zip $downloadDir/archives/nightly/zips
cp ${WORKSPACE}/plugins/org.eclipse.etrice.generator.c/build/distributions/org.eclipse.etrice.generator.c*.zip $downloadDir/archives/nightly/generators/eTrice-C-generator.zip
cp ${WORKSPACE}/plugins/org.eclipse.etrice.generator.cpp/build/distributions/org.eclipse.etrice.generator.cpp*.zip $downloadDir/archives/nightly/generators/eTrice-CPP-generator.zip
cp ${WORKSPACE}/plugins/org.eclipse.etrice.generator.java/build/distributions/org.eclipse.etrice.generator.java*.zip $downloadDir/archives/nightly/generators/eTrice-Java-generator.zip
echo 'done'
