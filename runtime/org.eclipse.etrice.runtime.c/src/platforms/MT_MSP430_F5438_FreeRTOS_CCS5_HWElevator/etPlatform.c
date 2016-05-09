/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution), Thomas Jung
 *
 *******************************************************************************/

#include "msp430f5438a.h"
/*#include "platform/etTimer.h" */
#include "hal_pmm.h"
#include "etPlatform.h"
#include "etDatatypes.h"

void enableLatchOutput(void);
void initClockSystem(void);
void initPortsForElevator(void);
void setData(unsigned char data);
void allLedsOff(void);
void genLatchClock(unsigned int mask);
unsigned char getFloorButtons(unsigned char floor);
void initMotor(void);
void initHw(void);
void enableInterrupt(void);


const unsigned char _7seg[15]={~0x3F,~0x06,~0x5B,~0x4F,~0x66,~0x6D,~0x7D,~0x07,~0x7F,~0x6F,  ~0xBF,~0x86,~0xDB,~0xCF,~0xE6};
const unsigned int latchClockFloorLowPattern[6]={0x0410,0x0440,0x0801,0x0804,0x0810,0x0840};
const unsigned int latchClockFloorHighPattern[6]={0x0420,0x0480,0x0802,0x0808,0x0820,0x880};
const unsigned int latchClockMotorPattern[12]={0x0201,0x0202,0x0204,0x0208,0x0210,0x0220,0x0240,0x0280,0x0401,0x0402,0x0404,0x0408};


const unsigned int doorPattern1[12]={0x0000,0x0201,0x0303,0x0387,0x03CF,0x03FF,0x03FF,0x03CF,0x0387,0x0303,0x0201,0x0000};
const unsigned int doorPattern2[12]={0x0000,0x0030,0x0078,0x00FC,0x01FE,0x03FF,0x03FF,0x01FE,0x00FC,0x0078,0x0030,0x0000};
const unsigned int doorPattern3[12]={0x0000,0x0200,0x0300,0x0380,0x03C0,0x03E0,0x03F0,0x03F8,0x03FC,0x03FE,0x03FF,0x03FF};


volatile unsigned char execute;
unsigned int floorLatchShadow[6];
unsigned char motorLatchShadow[12];

/* platform specific functions */


/*****************************************************/


void initHw(void) {
volatile unsigned int i=0;
volatile unsigned char j,m;

//	WDTCTL = WDTPW + 0x36; /*WDT as Timer; */
	WDTCTL = WDTPW + 0x80; /*disable WDT; */

	SetVCore(PMMCOREV_3);
	initClockSystem();

	initPortsForElevator();
	allLedsOff();
	enableLatchOutput();
	initMotor();
}

void vApplicationMallocFailedHook(void){
	while (1);
}

void enableInterrupt(void){
	/* SFRIE1|=WDTIE; */
	_enable_interrupt();
}
void initPortsForElevator(void){
	P2DIR |= 0x02;
	P2OUT &= ~0x02;

	P4OUT = 0x00;
	P4DIR = 0xFF;

	P3OUT = 0xC0;
	P3DIR = 0xFF;

	P8OUT = 0x00;
	P8DIR = 0x00;
	P8REN = 0xE0;
/* for time measurement */
	P10OUT = 0xC0;
	P10DIR = 0xC0;
}

void toggleTestLed(void){
	P2OUT ^= 0x02;
}
void enableLatchOutput(void){
	P3OUT &= ~0x80;
}

void setData(unsigned char data){
	P4OUT = data;
	P3OUT &= ~0x01;
	P3OUT |= 0x01;
}

void allLedsOff(void){
unsigned int i;
	P3OUT &= ~0x40;
	setData(0xFF);
	P4OUT &= ~0xFF;
	P3OUT &= ~0x1E;
	P3OUT |= 0x1E;
	P4OUT |= 0xFF;
	P3OUT &= ~0x1E;
	P3OUT |= 0x1E;
	for(i=0;i<6;i++){
		floorLatchShadow[i]=0;
	}
}

void writeTo7Seg(unsigned char data){
	if (data<=9){
	setData(_7seg[data]);
	genLatchClock(0x1001);
	}
}

void genLatchClock(unsigned int mask){
unsigned char dataLow, dataHigh;
	dataLow=mask & 0xFF;
	dataHigh=((mask >> 8) & 0xFF);
	P4OUT = ~dataLow;
	P3OUT &= ~dataHigh;
	P3OUT |= dataHigh;
	P4OUT = 0xFF;
	P3OUT &= ~dataHigh;
	P3OUT |= dataHigh;
}

void updateFloorLatch(floor){
unsigned char dataLow, dataHigh;

	dataLow=(unsigned char)(floorLatchShadow[floor]);
	dataHigh=(unsigned char) (floorLatchShadow[floor]>>8);

	setData(~dataLow);
	genLatchClock(latchClockFloorLowPattern[floor]);

	setData(~dataHigh);
	genLatchClock(latchClockFloorHighPattern[floor]);
}

void updateMotorLatch(void){
unsigned char i;
	for(i=0;i<12;i++){
		setData(~motorLatchShadow[i]);
		genLatchClock(latchClockMotorPattern[i]);
	}
}

unsigned char getMotorPosition(void){

	if (motorLatchShadow[10]==0x3C) return 0x80;
	if ((motorLatchShadow[7]==0xC0)&(motorLatchShadow[8]==0x03)) return 0x81;
	if (motorLatchShadow[5]==0x78) return 0x82;
	if ((motorLatchShadow[2]==0xC0)&(motorLatchShadow[3]==0x03)) return 0x83;
	if (motorLatchShadow[0]==0x78) return 0x84;
	return 0x00;

}

void shiftMotorUp(void){
unsigned char i;
	if(motorLatchShadow[0]&0x01)return;
	for(i=0;i<11;i++){
		motorLatchShadow[i]>>=1;
		if (motorLatchShadow[i+1]&0x01){motorLatchShadow[i]|=0x80;}
	}
	motorLatchShadow[11] >>=1;
	updateMotorLatch();
}

void shiftMotorDown(void){
unsigned char i;
	if (motorLatchShadow[11]&0x02)return;
	for(i=11;i>0;i--){
		motorLatchShadow[i]<<=1;
		if (motorLatchShadow[i-1]&0x80){motorLatchShadow[i]|=0x01;}
	}
	motorLatchShadow[0] <<=1;
	updateMotorLatch();
}

void initMotor(void){
unsigned char i;
	for(i=0;i<12;i++){
		motorLatchShadow[i]=0x00;
	}
	motorLatchShadow[11]=0x03;
	motorLatchShadow[10]=0xC0;
	updateMotorLatch();
}

void writeToButtonLed(unsigned char floor, unsigned char id, unsigned char onOff){
unsigned int data;
		data=id;
		data<<=10;
		if (floor>5)return;
		switch (onOff){
		case ON:
			floorLatchShadow[floor] |= data;
			break;
		case OFF:
			floorLatchShadow[floor] &= ~data;
			break;
		case TOGGLE:
			floorLatchShadow[floor]^=data;
			break;
		default:break;
		};
		updateFloorLatch(floor);
}

void writeToDoor(unsigned char floor, unsigned char data){
	/* clear door bits */
	/* avoid array out of bound access */
	if (data > 11)return;
	if(floor > 5)return;
	floorLatchShadow[floor] &= ~0x03FF;
	/* set door bits according data */
	floorLatchShadow[floor] |= (doorPattern3[data] & 0x3FF);
	updateFloorLatch(floor);
}

unsigned char getButtonStatus(unsigned char floor, unsigned int id){
unsigned char mask = 0x01;
unsigned char retVal=0;
	if ((floor == 0) && (id == DOWN_BUTTON_ID)){return 0;}
	if (id == CABINE_DOOR_BUTTON_ID){floor = 0; id=DOWN_BUTTON_ID;}
	mask <<= floor;
	P8OUT = mask;
	P8DIR = mask;
	if (P8IN & id) retVal=1;
	P8DIR = 0x00;
	return retVal;
}

unsigned char getFloorButtons(unsigned char floor){
unsigned char mask = 0x01;
	mask <<= floor;
	P8OUT = mask;
	P8DIR = mask;
	mask = P8IN & 0xE0;
	P8DIR = 0x00;

	return mask;
}

void initClockSystem(void){
	/*Select DCO range 4..60Mhz */
	UCSCTL1=DCORSEL_6;
	/*enable XT1 */
	P7SEL|=0x01;
	UCSCTL6=0x01CC;
	/* wait until Clock is ok */
	while(UCSCTL7&0x0002){UCSCTL7=0;}

	/* DCO => appr. 50Mhz */
	/* SMCLK MCLK => 25Mhz */
	UCSCTL2 = FLLD_1 + 0x2f8;

	/* Loop until XT1,XT2 & DCO fault flag is cleared */
	do
  	{
    	UCSCTL7 &= ~(XT2OFFG + XT1LFOFFG + XT1HFOFFG + DCOFFG);
    	                                        /* Clear XT2,XT1,DCO fault flags */
    	SFRIFG1 &= ~OFIFG;                      /* Clear fault flags */
  	}while (SFRIFG1&OFIFG);                   /* Test oscillator fault flag */

}

void vApplicationStackOverflowHook( xTaskHandle *pxTask, signed char *pcTaskName )
{
	( void ) pxTask;
	( void ) pcTaskName;

	/* Run time stack overflow checking is performed if
	configconfigCHECK_FOR_STACK_OVERFLOW is defined to 1 or 2.  This hook
	function is called if a stack overflow is detected. */
	taskDISABLE_INTERRUPTS();
	for( ;; );
}


/* The MSP430X port uses this callback function to configure its tick interrupt.
This allows the application to choose the tick interrupt source.
configTICK_VECTOR must also be set in FreeRTOSConfig.h to the correct
interrupt vector for the chosen tick interrupt source.  This implementation of
vApplicationSetupTimerInterrupt() generates the tick from timer A0, so in this
case configTICK_VECTOR is set to TIMER0_A0_VECTOR. */
void vApplicationSetupTimerInterrupt( void )
{
const unsigned short usACLK_Frequency_Hz = 32768;

	/* Ensure the timer is stopped. */
	TA0CTL = 0;

	/* Run the timer from the ACLK. */
	TA0CTL = TASSEL_1;

	/* Clear everything to start with. */
	TA0CTL |= TACLR;

	/* Set the compare match value according to the tick rate we want. */
	TA0CCR0 = usACLK_Frequency_Hz / configTICK_RATE_HZ;

	/* Enable the interrupts. */
	TA0CCTL0 = CCIE;

	/* Start up clean. */
	TA0CTL |= TACLR;

	/* Up mode. */
	TA0CTL |= MC_1;
}

/***************************************serial******************************/

void executeModel(void);

void initUART1(void){
	/* set IO Pins to Peripheral */

	UCA1CTL1 |= 0x01; /* hold the UART in Reset during initialization */
	UCA1CTL1 |= 0x80; /*CLK = SMCLK */

	P5SEL |= 0xC0;

	UCA1CTL0 = 0x00; /*8N1 LSB first */
	UCA1BR0 = 6;		/*Baudrate 0 */
	UCA1BR1 = 0;		/*Baudrate 1 */
	UCA1MCTL = 0x81;
	UCA1STAT = 0;	/*clear all flags */
	UCA1IRTCTL = 0;	/*IrDA Tx disabled */
	UCA1IRRCTL = 0;	/*IrDA Rx disabled */
	UCA1ABCTL = 0;	/*Autobaud disabled */

	UCA1CTL1 &= ~0x01; /*release the reset for operation */

	UCA1IE = 0x01;
}



#define ET_SERIAL_RXBUFFER_LEN	100
#define ET_SERIAL_TXBUFFER_LEN	100
unsigned char etSerialState = 0;
unsigned char etSerialLen;
unsigned char etSerialCS;
unsigned char etSerialRxBuffer[ET_SERIAL_RXBUFFER_LEN];
unsigned char *etSerialRxBufferWritePointer;
unsigned char etExecute;
unsigned char etSerialDataReceived=0;

void executeModel(void){
	if (etSerialRxBuffer[1] > 9){
		etExecute=1;
	}
}

void etSendSerialData(unsigned char len, unsigned char chnl, unsigned char * data){
unsigned char i;
unsigned char cs;

	while ((UCA1IFG & 0x02) == 0);
	UCA1TXBUF = 0x2D;
	while ((UCA1IFG & 0x02) == 0);
	UCA1TXBUF = 0xD4;

	cs = len;
	while ((UCA1IFG & 0x02) == 0);
	UCA1TXBUF = len;

	cs^=chnl;
	while ((UCA1IFG & 0x02) == 0);
	UCA1TXBUF = chnl;

	for (i=0;i<len-1;i++){
		/* wait until TX Buffer is empty */
		while ((UCA1IFG & 0x02) == 0);
		UCA1TXBUF = *data;
		cs ^= *data++;
	}

	while ((UCA1IFG & 0x02) == 0);
	UCA1TXBUF = cs;
}


#pragma vector=USCI_A1_VECTOR
interrupt void USCI_A1_ISR( void ){
unsigned char cChar;

switch (UCA1IV){
	case 2:
		/*receive interrupt */
		cChar = UCA1RXBUF;
		switch (etSerialState){
		case 0:
			/* synch pattern => 0x2d,0xD4 */
			if (cChar==0x2D){
				etSerialState++;
			}
			break;
		case 1:
			/* second byte of synch pattern */
			if (cChar==0xD4){
				etSerialState++;
				etSerialRxBufferWritePointer=etSerialRxBuffer;
				etSerialCS=0;
			}else{
				etSerialState=0;
			}
			break;
		case 2:
			/* first byte is the len */
			if ((etSerialLen=cChar) <= ET_SERIAL_RXBUFFER_LEN){
				*etSerialRxBufferWritePointer++=cChar;
				etSerialCS^=cChar;
				etSerialState++;
			}else{etSerialState=0;}
			break;
		case 3:
			/* receive the data */
			*etSerialRxBufferWritePointer++=cChar;
			etSerialCS^=cChar;
			etSerialLen--;
			if(etSerialLen==0){etSerialState++;}
			break;
		case 4:
			/* receive the CS */
			/*if (etSerialCS != cChar){etSerialState=0;} */
			/*else{ */
				/* command received OK */
				etSerialState=0;
				etSerialDataReceived=1;
				executeModel();
			/*} */
			break;

		default:etSerialState=0; break;
		};

		break;
	case 4:
		/*transmit interrupt */
			/*UCA1TXBUF = cChar; */
			/*UCA1IE &= ~UCTXIE; */
		break;
	default:;
	}
}

