#include <math.h>
#include <stdlib.h>
#include "vectorCalculator.h"

// NOTE: Returned arrays are malloced, call free() when done using them.

float* getForwardVector(double pitch, double yaw) {
      float* r = (float*)(malloc(3 * sizeof(float)));
      r[0] = (float)(cos(pitch) * sin(yaw));
      r[1] = (float)(sin(pitch) * -1);
      r[2] = (float)(cos(pitch) * cos(yaw));
      return r;
}

float* getRightVector(double yaw) {
      float* r = (float*)(malloc(3 * sizeof(float)));
      r[0] = (float)(cos(yaw));
      r[1] = 0.0;
      r[2] = (float)(sin(yaw) * -1);
      return r;
}

float* getUpVector(double pitch, double yaw) {
      float* forward = getForwardVector(pitch, yaw);
      float* right = getRightVector(yaw);
      float* r = (float*)(malloc(3 * sizeof(float)));
      for (unsigned int i = 0; i < 3; i++) {
            r[i] = forward[i] * right[i];
      }
      free(forward);
      free(right);
      return r;
}
