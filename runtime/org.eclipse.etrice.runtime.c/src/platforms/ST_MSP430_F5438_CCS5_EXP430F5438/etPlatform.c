/*******************************************************************************
 * Copyright (c) 2012 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#include "msp430f5438a.h"
#include "hal_MSP-EXP430F5438.h"
#include "platform/etTimer.h"


/* forward declarations */
static void prvSetupHardware(void);
void initIO(void);


/* implemenatation for eTrice interfaces*/

void etUserEntry(void){
	prvSetupHardware();
	etTimer_init();
}

void etUserPreRun(void){
	_enable_interrupt();
}

void etUserPostRun(void){ }
void etUserExit(void){ }


/* platform specific functions */

static void prvSetupHardware(void) {
	/* Convert a Hz value to a KHz value, as required by the Init_FLL_Settle()
	 function. */
	unsigned long ulCPU_Clock_KHz = (25000000UL / 1000UL );

	/* Disable the watchdog. */
	WDTCTL = WDTPW + 0x36;
	SFRIE1 |= WDTIE;

	/* select port pin functions */
	halBoardInit();

	P1DIR |= 0x03;
	P2DIR &= ~0xC0;
	P2REN |= 0xC0;
	P2OUT |= 0xC0;

	LFXT_Start(XT1DRIVE_0); 								/* enable oszillator */
	Init_FLL_Settle((unsigned short) ulCPU_Clock_KHz, 488);	/* clock divisor */


}

unsigned char getButtonStatus(unsigned int id){
	switch (id){
	case 1:return P2IN & 0x80;
		break;
	case 2:return P2IN & 0x40;
		break;
	default: return 0xFF;
	};
}

void setLedPin (unsigned int id, unsigned int onOff){
	switch (id){
	case 1:
		if (onOff){
			P1OUT |= 0x01;
		}else{
			P1OUT &= ~0x01;
		}
		break;
	case 2:
		if (onOff){
			P1OUT |= 0x02;
		}else{
			P1OUT &= ~0x02;
		}
		break;
	default:
	}
}

