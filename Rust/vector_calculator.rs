use std::vec::Vec;
pub struct Vector_Calculator { }

// TODO: test
// not sure if this compiles yet lol
pub impl Vector_Calculator {
      pub fn calculate_forward_vector(pitch: f32, yaw: f32) -> Vec<f32> {// not gonna use doubles bc rust types are a pain
            vec![
                  pitch.cos() * yaw.sin(),
                  pitch.sin() * -1,
                  pitch.cos() * yaw.cos()
            ]
      }

      pub fn calculate_right_vector(yaw: f32) -> Vec<f32> {
            vec![
                  yaw.cos(),
                  0.0,
                  (yaw.sin() * -1)
            ]
      }

      pub fn calculate_up_vector(pitch: f32, yaw: f32) -> Vec<f32> {
            cross(
                  Vector_Calculator::calculate_forward_vector(pitch, yaw),
                  Vector_Calculator::calculate_up_vector(yaw)
            )
      }
}

fn cross(vec1: Vec<f32>, vec2: Vec<f32>) -> Vec<f32> {
      let mut r: Vec<f32> = Vec::new();
      let mut i: usize = 0;
      for n in vec1 {
            r.push(vec1[i] * vec2[i]);
            i += 1;
      }
      return r;
}