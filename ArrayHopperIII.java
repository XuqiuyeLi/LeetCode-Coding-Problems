public class Solution {
  public int minJump(int[] array) {
    // Assume all non-negative integers
    // array is not null and has at least one element
    
    // corner case
    if(array.length == 1){
      return array[array.length - 1] == 0 ? -1: 1;
    }
    
    int[] M = new int[array.length];
    // Base case
    // the last element 
    M[M.length - 1] = array[array.length - 1] == 0 ? -1: 1;
    // 从倒数第二个element倒着做
    for(int i = M.length - 2; i >= 0; i--){
        // cannot reach
        if(array[i] == 0){
          M[i] = -1; 
          continue;
        }
        // one jump to the end 
        if(i + array[i] > array.length - 1){
          M[i] = 1;
          continue;
        }
        // needs to jump to another index first
        int minJump = Integer.MAX_VALUE;
        for(int j = array[i]; j > 0; j--){
          if(M[i+j] != -1 && M[i+j] < minJump){
            minJump = M[i+j];
          }
          // Do nothing if -1 or M[i+j] >= minJump
        }
        M[i] = minJump == Integer.MAX_VALUE ? -1 : minJump + 1;
    }
    return M[0];
  }
  // Mistake:
  // 1. change the corner case: if {0}, return 1;
  // 2. change the base case of M
}