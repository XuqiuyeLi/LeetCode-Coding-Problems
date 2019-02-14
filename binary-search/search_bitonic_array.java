/*
 *
 * Search for a target number in a bitonic array, 
 * return the index of the target number if found in the array, or return -1.
 *
 * A bitonic array is a combination of two sequence: 
 * the first sequence is a monotonically increasing one and 
 * the second sequence is a monotonically decreasing one.
 *
 * @author Summer Li
 */



public class Solution {
  // Please review the mistake: line 15 no "break" statement
  public int search(int[] array, int target) {
    // assume no duplicate values
    if(array == null || array.length == 0){
      return -1;
    }
    // find the split index of two arrays
    int secondArr = array.length - 1;
    int result1 = -1, result2 = -1;
    for(int i = 0; i < array.length - 1; i++){
      if(array[i] > array[i+1]){
        secondArr = i + 1;
        // !!!! debug: didn't have break statement
        // the array keeps looping since the 2nd array is decreasing
        break;
      }
    }
    // Mistake 2: ArrayIndexOutOfBound -> if only 1 element, array[0 - 1]
    if(target >= array[0] && secondArr > 0 && target <= array[secondArr - 1]){
      // search in first increasing array
      result1 = searchFirst(array, 0, secondArr - 1, target);
    }
    // Mistake 3: if target lies in range of 1st array doesn't process to 2nd array
    // Cannot directly just return the "-1" value from 1st array before searching 2nd
    if(target >= array[array.length - 1] && target <= array[secondArr]){
      // search in second decreasing array
      result2 = searchSecond(array, secondArr, array.length - 1, target);
    }
    if(result1 != -1){
      return result1;
    }
    return result2;
  }


  private int searchFirst(int[] array, int left, int right, int target){
      while(left <= right){
        int mid = left + (right - left) / 2;
        if(array[mid] == target){
          return mid;
        }
        else if(array[mid] < target){
          left = mid + 1;
        }
        else{
          right = mid - 1;
        }
      }
      // not found
      return -1; 
  } 
  

  private int searchSecond(int[] array, int left, int right, int target){
      // return any index of target value if duplicates 
      while(left <= right){
        int mid = left + (right - left) / 2;
        if(array[mid] == target){
          return mid;
        }
        else if(array[mid] > target){
          left = mid + 1;
        }
        else{
          right = mid - 1;
        }
      }
      // not found
      return -1;
  }
  // Time: O(N)
}
