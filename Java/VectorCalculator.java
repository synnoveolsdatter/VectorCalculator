public class VectorCalculator {
      /**
       * @return[0] = x, @return[1] = y, @return[2] = z
       */
      public static double[] getForwardVector(double pitch, double yaw) {
            return new double[] {
                  (Math.cos(pitch) * Math.sin(yaw)),
                  (Math.sin(pitch) * -1),
                  (Math.cos(pitch) * Math.cos(yaw))
            };
      }

      public static double[] getRightVector(double yaw) {
            return new double[] {
                  Math.cos(yaw),
                  (double)0.0,
                  Math.sin(yaw) * -1
            };
      }

      public static double[] getUpVector(double pitch, double yaw) {
            return cross(
                  getForwardVector(pitch, yaw),
                  getRightVector(yaw)
            );
      }


      public static float[] getForwardVectorF(float pitch, float yaw) {
           return new float[] {
               Math.cos(pitch) * Math.sin(yaw),
               Math.sin(pitch) * -1,
               Math.cos(pitch) * Math.cos(yaw)
           }
      }

      public static float[] getRightVectorF(float yaw) {
           return new double[] {
               Math.cos(yaw),
               (float)0.0,// forgot what 0.0 defaults to
               Math.sin(yaw) * -1
           }
      }

      public static float[] getUpVectorF(float pitch, float yaw) {
           return crossF(
                getForwardVectorF(pitch, yaw),
                getRightVectorF(yaw)
           );
      }

      private static double[] cross(double[] vector1, double[] vector2) {
            double[] r = new double[3];// emphasis on "know your usecases" lol
            for (int i = 0; i < 3; i++) {
                  r[i] = vector1[i] * vector2[i];
            }
            return r;
      }

      private static float[] crossF(float[] vector1, float[] vector2) {
            float[] r = new float[3];// emphasis on "know your usecases" lol
            for (int i = 0; i < 3; i++) {
                  r[i] = vector1[i] * vector2[i];
            }
            return r;
      }
}
