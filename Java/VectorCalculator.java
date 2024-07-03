public class VectorCalculator {
      /**
       * @return[0] = x, @return[1] = y, @return[2] = z
       */
      public static float[] getForwardVector(double pitch, double yaw) {
            return new float[] {
                  (float)(Math.cos(pitch) * Math.sin(yaw)),
                  (float)(Math.sin(pitch) * -1),
                  (float)(Math.cos(pitch) * Math.cos(yaw))
            };
      }

      public static float[] getRightVector(double yaw) {
            return new float[] {
                  (float)(Math.cos(yaw)),
                  0f,
                  (float)(Math.sin(yaw) * -1)
            };
      }

      public static float[] getUpVector(double pitch, double yaw) {
            return cross(
                  getForwardVector(pitch, yaw),
                  getRightVector(yaw)
            );
      }

      private static float[] cross(float[] vector1, float[] vector2) {
            float[] r = new float[3];// emphasis on "know your usecases" lol
            for (int i = 0; i < 3; i++) {
                  r[i] = vector1[i] * vector2[i];
            }
            return r;
      }
}