Resource Requirements
=====================

There is often the question: What are the costs of the high level modeling language? The answer depends on many parameters e.g. compiler settings, uC architecture, configuration of the runtime system, model size...

This chapter should give an idea what the costs are in terms of RAM and ROM/FLash consumption. Basically there are three execution models which are supported from eTrice.<ol>
<li>Message Passing</li><li>Polled</li><li>Mixed</li>
</ol>For a pure polled execution model there is no infrastructure at all required. Whenever a message based system is used (Message Passing or Mixed) a message queue and a message service is required.<br>  
The numbers you will find here may vary from what you see in your application due to the many parameters. The numbers are got from the Dave Tutorial model (C runtime library and code generator) with full debug features enabled, on an ARM Cortex M4 architecture.<br><br>You should also keep in mind that the larger the model the smaller the relative overhead. In fact, a large model with good structure may need less recourses than hand made code of the same functionality.

<table style="vertical-align: middle;" class="table">
<thead>
<tr>
	<th colspan="3">Requirements</th>
</tr>
</thead>
<tbody>
<tr>
	<td>etRuntime</td>
	<td><br>RAM: 28Byte<br>CODE: 3,5kByte
	 </td>
	<td>This is the size of the pure runtime library for the single threaded execution model. The files from *etrice_c_runtime* contributes to this number. For the multi threaded execution model the code size will increase a bit. But negligible compared to the required OS size. The RAM size is so minimal because the message queue is not included in this number. This number contains 2 * 8 Byte for a time variable and some pointers.</td>
</tr>
<tr>
	<td>Message</td>
	<td>The minimum message size is 8 Byte</td>
	<td>A message consists of a header (8 Byte, 4 Byte for *next* pointer, 2 Bytes address, 2 Bytes event ID) plus payload. The message size is defined in .etphys with *msgblocksize* (payloadsize = *msgblocksize* - 8). The message size will be defined for each thread. Keep in mind that pointer sizes may vary from platform to platform.</td>
</tr>
<tr>
	<td>Message Queue</td>
	<td>*msgblocksize* * *msgpoolsize*</td>
	<td>The memory requirement is *msgblocksize* * *msgpoolsize*. This values should be carefully adapted to your memory resources on one hand and to the needs of your application model on the other hand. Each message you define in the model must fit into the defined block size (including header). The pool size determines how many messages can be in the queue at a given time.<br><br>Due to the fact that during startup a lot of	initialization messages will be put into the queue, the startup phase often determines the *msgpoolsize* size of a system.</td>
</tr>
<tr>
	<td>Message Service</td>
	<td>RAM: 112 Byte</td>
	<td>The Message Service contains the execution loop for each thread. The Code is contained in *etRuntime*, but the data is required for each thread, just once in a single threaded environment. The MessageService needs pointers to the message buffer, mutexe, semaphore, thread and some other administrative data. </td>
</tr>
<tr>
	<td>Thread</td>
	<td></td>
	<td>Each thread requires a stack. The stack size must be configured with *stacksize* in .etphys for each thread. The OS must be configured to satisfy the required resources.</td>
</tr>
<tr>
	<td>Actor</td>
	<td>ROM: 12Bytes/Port<br><br>RAM: 4Byte<br>	+ 2Byte FSM<br>	+ History<br>	+ Application Attributes</td>	
	<td>For each Actor a struct is generated. It contains a const part and a variable part. The const part contains all ports with there peer addresses and optionally debug infos. This represents the structure of the model which is static in C.<br><br>The RAM part contains a pointer to the const part, the state variable and a history array from the size of the deepest history level of the FSM. And of course all application Attributes.</td>
</tr>
<tr>
	<td>Timing</td>
	<td></td>
	<td>All model times are relative to the system start and are derived from the system tick. The granularity of the model timers can not increase the granularity of the system tick. E.g. if you configure the system tick with 10ms a timer will run at least 10ms regardless if you specify less than 10ms.<br><br>In .etphys you can specify the interval of a thread. That means that flow ports and do actions which are running on a given thread will be polled/triggerd with this interval. In a multi threaded system you can specify the interval per thread.<br><br>If Actors with flow ports or do actions are deployed on a given thread, the runtime system requires an OS timer for this thread.</td>
</tr>

</tbody>
</table>

As a result from the above table you should be able to assess the costs on the one hand and the benefits of a model on the other hand for your specific application. As a rough recommendation and depending on your specific application it might be reasonable to start modeling with a single threaded application on a microcontroller starting from 16KByte Flash an 4KByte RAM. For example a XMC&trade; Cortex M0 from Infineon with 64KByte Flash and 16kByte RAM provides a comfortable platform for modelling even multi threaded systems with underlaying operating system.  
