/**
 * @author generated by eTrice
 *
 * Header File of DataClass DTcpPayload
 * 
 */

#ifndef _ETRICE_API_TCP_DTCPPAYLOAD_H_
#define _ETRICE_API_TCP_DTCPPAYLOAD_H_

#include "etDatatypes.h"

/* include all referenced room classes */

		
typedef struct {
	/*--------------------- attributes ---------------------*/
	 int32 connectionId;
	 int32 length;
	 int8 data[32]
	;
} DTcpPayload;



/*--------------------- operations ---------------------*/
 int32 DTcpPayload_getMaxLength(DTcpPayload* self);
 void DTcpPayload_setData(DTcpPayload* self, int8* value, int32 size);
 charPtr DTcpPayload_getAsString(DTcpPayload* self);
 void DTcpPayload_setAsString(DTcpPayload* self, charPtr value);

/* deep copy */
void DTcpPayload_deepCopy(DTcpPayload* source, DTcpPayload* target);


#endif /* _ETRICE_API_TCP_DTCPPAYLOAD_H_ */

