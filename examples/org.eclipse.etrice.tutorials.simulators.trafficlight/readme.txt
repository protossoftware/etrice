
trafficlight is a simple gui with a pedestrian traffic light and a car traffic light.  
trafficlight is a tcp/ip socket server that sends and takes ascii commands that are terminated with a line end or a carriage return 

* start application:
java -jar trafficlight.jar <port>

* example:
java -jar trafficlight.jar 4441

* incoming commands:
	carLightRed=on\n
	carLightRed=off\n
	carLightYellow=on\n
	carLightYellow=off\n
	carLightGreen=on\n
	carLightGreen=off\n

	pedLightRed=on\n
	pedLightRed=off\n
	pedLightGreen=on\n
	pedLightGreen=off\n

	requestButton=on\n
	requestButton=off\n

* outgoing commands:
	pressedRequestButton\n
	




