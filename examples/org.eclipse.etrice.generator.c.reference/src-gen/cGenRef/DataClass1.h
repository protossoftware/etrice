#ifndef _DataClass1_H_
#define _DataClass1_H_

#include "datatypes.h"

/* TODO: includes only for used DataClasses, also for other models */
#include "DataClass2.h"

//--------------------- begin user code
	// usercode1
//--------------------- end user code
		
typedef struct {
	//--------------------- begin user code
		// usercode2
	//--------------------- end user code
	//--------------------- attributes
	int32 Attr1;
	DataClass2 ComplexAttr;
	float32 Attr3;
} DataClass1;

// TODO: do we need setters and getters for C and C++ ?

//--------------------- operations
int32 DataClass1_MultiplyWithAttr1 (DataClass1* self, int32 value);
float32 DataClass1_MultiplyWithAttr3 (DataClass1* self, float32 value);

// deep copy
void DataClass1_deepCopy(DataClass1* source, DataClass1* target);

#endif /* _DataClass1_H_ */

