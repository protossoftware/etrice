/*
 * etPlatform.h
 *
 *  Created on: 23.06.2012
 *      Author: junggtho
 */

#ifndef ETPLATFORM_H_
#define ETPLATFORM_H_


#define UP_SWITCH_LED		0x02
#define DOWN_SWITCH_LED		0x01
#define CABINE_SWITCH_LED	0x04

#define CABINE_BUTTON_ID		0x80
#define UP_BUTTON_ID			0x40
#define DOWN_BUTTON_ID			0x20
#define CABINE_DOOR_BUTTON_ID	0x10

#define ON		0x01
#define OFF		0x02
#define TOGGLE	0x03


#include "etTime.h"

void writeTo7Seg(unsigned char data);
void writeToDoor(unsigned char floor, unsigned char data);
unsigned char getButtonStatus(unsigned char floor, unsigned int id);
void writeToButtonLed(unsigned char floor, unsigned char id, unsigned char onOff);
void shiftMotorDown(void);
void shiftMotorUp(void);
unsigned char getMotorPosition(void);
void toggleTestLed(void);
void initHw(void);
void enableInterrupt(void);
void getTimeFromTarget(etTime *t);

/*serial */
void etSendSerialData(unsigned char len, unsigned char chnl, unsigned char * data);
extern unsigned char etSerialDataReceived;
extern unsigned char etSerialRxBuffer[];



#endif /* ETPLATFORM_H_ */
