using System;
using System.Numerics;

namespace VectorCalculator {
      public class VectorCalculator {
            public static Vector3 CalculateForwardVector(double pitch, double yaw) {
                  return new Vector3(
                        Math.Cos(pitch) * Math.Sin(yaw),
                        -Math.Sin(pitch),
                        Math.Cos(pitch) * Math.Cos(yaw)
                  );
            }

            public static Vector3 CalculateRightVector(double yaw) {
                  return new Vector3(
                        Math.Cos(yaw),
                        0,
                        -Math.Sin(yaw)
                  );
            }

            public static Vector3 CalculateUpVector(double pitch, double yaw) {
                  return Vector3.Cross(
                        VectorCalculator.CalculateForwardVector(pitch, yaw),
                        VectorCalculator.CalculateRightVector(yaw)
                  );
            }
      }
}