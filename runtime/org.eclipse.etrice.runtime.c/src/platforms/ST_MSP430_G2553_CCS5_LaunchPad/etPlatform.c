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

#include "msp430g2553.h"
#include "platform/etTimer.h"


/* forward declarations */


/* implemenatation for eTrice interfaces*/

void etUserEntry(void){
	  //Use WDT as interrupt timer
	  WDTCTL = WDTPW + 0x16;

	  DCOCTL =  CALDCO_16MHZ;
	  BCSCTL1 = CALBC1_16MHZ;
	  BCSCTL2 = 0x00;
	  BCSCTL3 = 0x0C;

	  P1DIR = 0x01;

	  IE1 |= 1;

	  etTimer_init();

	  _enable_interrupt();


}

void etUserPreRun(void){
	_enable_interrupt();
}

void etUserPostRun(void){ }
void etUserExit(void){ }


/* platform specific functions */


