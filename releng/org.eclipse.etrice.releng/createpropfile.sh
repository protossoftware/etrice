rm -rf buildroot
mkdir buildroot
mkdir buildroot/test.results
:
COMPACT_BUILD_ID="${BUILD_ID//[-_]}"
COMPACT_BUILD_ID="${COMPACT_BUILD_ID:0:12}"
:
{
	cat "${WORKSPACE}/etrice_local_repo/releng/org.eclipse.etrice.releng/build.properties"

	echo
	echo "# Define the path to the repository location"
	echo "etrice.repo=${WORKSPACE}/etrice_local_repo"

	echo
	echo "# Define the Build ID (added by Hudson job definition)"
	echo "build.id=${BUILD_TYPE}${COMPACT_BUILD_ID}"

	echo
	echo "# Define the Build Alias (added by Hudson job definition)"
	echo "build.alias=${BUILD_ALIAS}"

	echo
	echo "# Define Hudson Build ID (added by Hudson job definition)"
	echo "hudson.build.id=${BUILD_ID}"

	echo
	echo "# override qualifier replacement set in build.properties"
	echo "qualifier.replacement.*=generator:buildTimestamp"
	echo "generator.buildTimestamp.format='${BUILD_TYPE}'yyyyMMddHHmm"

	echo
	echo "# Override default locations (added by Hudson job definition)"
	echo "buckminster.output.root=${WORKSPACE}/buildroot/buckminster.build"
	echo "buckminster.temp.root=${WORKSPACE}/buildroot/buckminster.temp"
	echo "eclipse.staging.area=/shared/download-staging.priv/modeling/mdt/etrice"
	echo "target.platform=${WORKSPACE}/buildroot/target.platform"
	echo "integration.model.path=${WORKSPACE}/etrice_local_repo/tests/org.eclipse.etrice.integration.tests/model"
	echo "java.tests.model.path=${WORKSPACE}/etrice_local_repo/tests/org.eclipse.etrice.generator.java.tests/models"
	echo "test.results=${WORKSPACE}/buildroot/test.results"

	echo
	echo "site.signing=${SITE_SIGNING}"

} > buildroot/build.properties
:
{
	echo "# Define the Build ID to use for tagging (added by Hudson job definition)"
	echo "build.id=${COMPACT_BUILD_ID}"

} > buildroot/tagging.properties
:
