/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * CONTRIBUTORS:
 * 		Henrik Rentz-Reichert (initial contribution)
 *
 *******************************************************************************/

#include "common/containers/Vector.h"

namespace etRuntime {

size_t VectorStats::nallocs = 0;
size_t VectorStats::ndeallocs = 0;
size_t VectorStats::ncreated = 0;
size_t VectorStats::ndestroyed = 0;

} /* namespace etRuntime */
