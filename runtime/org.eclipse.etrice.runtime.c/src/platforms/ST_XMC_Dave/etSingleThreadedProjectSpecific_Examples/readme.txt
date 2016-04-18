The SingleThreaded runtime environment is very simple to adapt to your specific target.
The following functions must be implemented:

- getTimeFromTarget
This function returns the target time in sec and nsec. Normaly it requires to set up 
a timer interrupt and call a count function on a fixed time base. getTimeFromTarget just returns 
the time to the eTrice environment.
Take care about the interruptprotection (or some other mechanism) during reading the etTargetTime.
On must targets it is not possible to read it atomic.


-etSingleThreadedProjectSpecificUserEntry
This function will be called during startup. Here you have to initialize your HW and
everything else that is needed to setup your timer interrupts.

Within this directory you find some example implementations for dedicated targets. 
Please copy one of those example files into your project and compile it in the your context.
If necessary adapt the file to your needs.