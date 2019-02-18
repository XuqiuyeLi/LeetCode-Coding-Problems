// Max product of cutting rope of n meters


public class Solution {
  public int maxProduct(int length) {
    // Assume length >= 2
    // M[i] represents the max product of i meters rope
    int[] M = new int[length + 1];
    // Base cases
    M[0] = 0; 
    M[1] = 0;
    for(int i = 2; i <= length; i++){
      int curMax = 0;
      for(int j = 1; j < i; j++){
        curMax = Math.max(curMax, Math.max(j, M[j]) * (i - j));
      }
      M[i] = curMax;
    }
    return M[length];
  }
}