#include <math.h>
#include <stdlib.h>
#ifndef _VEC_CALC
#define _VEC_CALC

/** For all:
 * @return[0] = x, @return[1] = y, @return[2] = z
 *
 * NOTE - returned arrays are malloced
*/

float* getForwardVector(double pitch, double yaw); 

float* getRightVector(double yaw);

float* getUpVector(double pitch, double yaw);

#endif
