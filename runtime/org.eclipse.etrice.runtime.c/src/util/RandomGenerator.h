/*******************************************************************************
 * Copyright (c) 2014 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * CONTRIBUTORS:
 * 		Thomas Schuetz (initial contribution)
 *
 *******************************************************************************/

#ifndef RANDOMGENERATOR_H_
#define RANDOMGENERATOR_H_

#include "etDatatypes.h"

#ifdef ET_FLOAT64

typedef struct RandomGenerator {
	etFloat64 seed;
	etFloat64 max;
	etFloat64 min;
	etFloat64 range;
	etFloat64 current;
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
* 	etFloat64 result = RandomNumberGenerator_getNext(&rand);
* 	(...)
* 	result now holds a random number between -10 and 10;
*/
void RandomGenerator_init(RandomGenerator* self, etFloat64 seed, etFloat64 min, etFloat64 max);

/**
* initialze once before use.
*
* @param self self pointer of class.
* @return A random number between min and max
*
*/
etFloat64 RandomGenerator_getNext(RandomGenerator* self);


#endif
#endif /* RANDOMGENERATOR_H_ */
