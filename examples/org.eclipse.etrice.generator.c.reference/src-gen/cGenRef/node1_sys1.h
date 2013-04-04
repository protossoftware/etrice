/**
 * @author generated by eTrice
 *
 * Header File of Node node1 with SubSystem sys1
 * 
 */

#ifndef _NODE1_SYS1_H_
#define _NODE1_SYS1_H_



/* lifecycle functions
 * init -> start -> run (loop) -> stop -> destroy
 */

void node1_sys1_init(void);		/* lifecycle init  	 */
void node1_sys1_start(void);	/* lifecycle start 	 */

void node1_sys1_run(void);		/* lifecycle run 	 */

void node1_sys1_stop(void); 	/* lifecycle stop	 */
void node1_sys1_destroy(void); 	/* lifecycle destroy */

void node1_sys1_shutdown(void);  /* shutdown the dispatcher loop */


#endif /* _NODE1_SYS1_H_ */


