public class Solution {
  public int minJump(int[] array) {
    // Assume all non-negative integers
    // array is not null and has at least one element
    
    // corner case
    if(array.length == 1){
      return 0;
    }
    
    int[] M = new int[array.length];
    // Base case
    // the last element is always 0 because it's the destination
    M[M.length - 1] = 0;
    // 从倒数第二个element倒着做
    for(int i = M.length - 2; i >= 0; i--){
        // cannot reach
        if(array[i] == 0){
          M[i] = -1; 
          continue;
        }
        // one jump to the end 
        if(i + array[i] >= array.length - 1){
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
}