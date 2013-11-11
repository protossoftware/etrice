Instructions to install Eclipse dependencies as Maven artifacts to the local repository
=======================================================================================

* set the environment variable ETRICE_TARGET_PLATFORM to the path of your Eclipse installation (the directory named eclipse)
* run the install-dependencies.bat script
* if eTrice is installed
** set ETRICE_DEPLOY to the path of your Eclipse installation (the directory named eclipse)
** replace the qualifier 'exp' in install-generator.bat with the actual qualifier of your plugins
* if you build eTrice from your workspace
** select a path where eTrice plugins should be deployed to by PDE
** create an environment variable ETRICE_DEPLOY to this path
** run export-generator.launch
* run install-generator.bat
* run install_org.eclipse.etrice.generator.java.mvn.launch
