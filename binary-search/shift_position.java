
/*
 * Given an integer array A, A is sorted in ascending order first then shifted by an arbitrary number of positions, 
 * For Example, A = {3, 4, 5, 1, 2} (shifted left by 2 positions). Find the index of the smallest number.
 *
 * Assumption: no duplicates
 *
 */




public class Solution {
  // solution 2: use binary search, Time O(logN)
  public int shiftPosition(int[] array) {
    if(array == null || array.length == 0){
      return -1;
    }
    if(array.length == 1){
      return 0;
    }
    int left = 0;
    int right = array.length - 1;
    // with at least two elements
    while(left < right - 1){
      int mid = left + (right - left) / 2;
      // case 1: shift == 0
      if(array[left] < array[mid] && array[mid] < array[right]){
        return left;
      }
      // case 2: shift > 0
      // case 2.1 left - mid array
      else if(array[left] < array[mid] && array[mid] > array[right]){
        left = mid;
      }
      // case 2.2 mid - right array
      else if(array[left] > array[mid] && array[mid] < array[right]){
        right = mid;
      }
    }
    // post - processing
    if(array[left] < array[right]){
      return left;
    }
    return right;                                                                                                                       
  }
  
  public int shiftPosition1(int[] array) {
    // solution 1: brute force, time O(N)
    if(array == null || array.length == 0){
      return -1;
    }
    int shiftStart = 0;
    for(int i = 0; i < array.length - 1; i++){
      if(array[i] > array[i+1]){
        shiftStart = i + 1;
      }
    }
    return shiftStart;
  }
}
