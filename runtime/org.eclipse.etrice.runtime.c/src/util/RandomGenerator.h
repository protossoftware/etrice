/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef RANDOMGENERATOR_H_
#define RANDOMGENERATOR_H_

#include "etDatatypes.h"

typedef struct RandomGenerator {
	float64 seed;
	float64 max;
	float64 min;
	float64 range;
	float64 current;
}RandomGenerator;

/**
* initialze once before use.
*
* @param self self pointer of class.
* @param seed seed for the random function. Must be ]0,*] - should be ]0,1[ for a good start
* @param min minimum for value range of resulting numbers
* @param max maximum for value range of resulting numbers
*
* example:
* 	(...)
*	RandomNumberGenerator rand;
*	RandomNumberGenerator_init(&rand, 0.321, -10, 10);
* 	float64 result = RandomNumberGenerator_getNext(&rand);
* 	(...)
* 	result now holds a random number between -10 and 10;
*/
void RandomGenerator_init(RandomGenerator* self, float64 seed, float64 min, float64 max);

/**
* initialze once before use.
*
* @param self self pointer of class.
* @return A random number between min and max
*
*/
float64 RandomGenerator_getNext(RandomGenerator* self);


#endif /* RANDOMGENERATOR_H_ */
