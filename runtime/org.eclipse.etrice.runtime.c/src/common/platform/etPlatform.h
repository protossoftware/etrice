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

#ifndef __ETPLATFORM_H__
#define __ETPLATFORM_H__

/*
 * etPlatform.h defines a generic interface for platform specific implementations
 *
 * */

/*
 * Platform startup and shutdown -> generated code for SubSystemClass uses these interfaces
 * */

void etUserEntry(void);
void etUserPreRun(void);
/* void etUserRun(void); */ /* TODO: do we need this function? */
void etUserPostRun(void);
void etUserExit(void);

#endif /* __ETPLATFORM_H__ */
