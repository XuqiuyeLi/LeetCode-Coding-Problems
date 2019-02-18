public class Solution {
  public boolean canJump(int[] array) {
    // Assume all non-negative integers
    // array is not null and has at least one element
    
    // corner case
    if(array.length == 1){
      return true;
    }
    
    Boolean[] M = new Boolean[array.length];
    // Base case
    // the last element is always true because it's the destination
    M[M.length - 1] = true;
    // 从倒数第二个element倒着做
    for(int i = M.length - 2; i >= 0; i--){
        if(array[i] == 0){
          M[i] = false;
        }
        for(int j = 1; j <= array[i]; j++){
          // can reach the end 
          if( i + j >= array.length - 1 || M[i + j] == true) {
            M[i] = true;
            break;
          }
          // last jump, still not reach 
          if(j == array[i] && M[i + j] == false){
            M[i] = false;
          }
        }
    }
    return M[0];
  }
  // Time: O(N^2)
  // Space: O(N)
}
