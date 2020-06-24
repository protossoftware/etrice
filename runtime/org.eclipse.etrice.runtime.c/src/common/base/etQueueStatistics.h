/*******************************************************************************
 * Copyright (c) 2011 protos software gmbh (http://www.protos.de).
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

#ifndef COMMON_BASE_ETQUEUESTATISTICS_H_
#define COMMON_BASE_ETQUEUESTATISTICS_H_

#include "etDatatypes.h"

ET_EXTERN_C_BEGIN

/**
 * a data structure for the queue statistics
 */
typedef struct etQueueStatistics {
	etInt16 highWaterMark;			/**< high water mark */
	etInt16 lowWaterMark;			/**< low water mark */
	etInt16 nFailingRequests;		/**< queue would have exceeded maximum size */
}
etQueueStatistics;

void etQueueStatistics_init(etQueueStatistics* self);

void etQueueStatistics_reset(etQueueStatistics* self, etInt16 lowWaterMark);

ET_EXTERN_C_END

#endif /* COMMON_BASE_ETQUEUESTATISTICS_H_ */
