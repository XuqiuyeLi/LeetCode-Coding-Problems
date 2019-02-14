/*
 *
 * Given an integer number n, find its integer square root.
 *
 */


public class Solution {
  public int sqrt(int x) {
    // x is >= 0
    if(x == 0){
      return 0;
    }
    if(x <= 2){
      return 1;
    }
    int left = 1;
    int right = x - 1;
    // x > 2
    while(left < right - 1){
      int half = left + (right - left) / 2;
      // if half * half, will be integer overflow problem
      // 所以倒过来做，用 x ／ half
      int remain = x / half;
      if(remain == half){
        return half;
      }
      // half * half > x case 
      else if(remain < half){
        right = half;
      }
      else{
        left = half;
      }
    }
    // post-processing
    // because right will be the half and > remain 
    return left;
  }
}