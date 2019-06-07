/*******************************************************************************
 * Copyright (c) 2017 protos software gmbh (http://www.protos.de).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
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
