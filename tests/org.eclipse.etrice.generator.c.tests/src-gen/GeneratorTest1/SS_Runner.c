/**
 * @author generated by eTrice
 *
 * this class contains the main function running component SS
 * it instantiates SS and starts and ends the lifecycle
 */


#include "SS.h"

#include "debugging/etLogger.h"
#include "debugging/etMSCLogger.h"
#include "platform/etPlatform.h"


/**
 * main function
 * creates component and starts and stops the lifecycle
 */

int main(void) {
	etUserEntry(); /* platform specific */
	
	etLogger_logInfo("***   T H E   B E G I N   ***");
	ET_MSC_LOGGER_OPEN("main");

	/* startup sequence  of lifecycle */
	SS_init(); 		/* lifecycle init */
	SS_start(); 	/* lifecycle start */

	etUserPreRun(); /* platform specific */

	/* run Scheduler */
	SS_run();

	etUserPostRun(); /* platform specific */

	/* shutdown sequence of lifecycle */
	SS_stop(); 		/* lifecycle stop */
	SS_destroy(); 	/* lifecycle destroy */

	ET_MSC_LOGGER_CLOSE
	etLogger_logInfo("***   T H E   E N D   ***");

	etUserExit(); /* platform specific */

	return 0;
}

