public class Solution {
  public int search(int[] array, int target) {
    if(array == null || array.length == 0){
      return -1;
    }
    // assume no duplicate
    // Case 1: Shift = 0
    // Case 2 Shift > 0, divide into two arrays 
    int left = 0;
    int right = array.length - 1;
    while(left <= right){
      int mid = left + (right - left) / 2;
      // in this subarray, shift = 0
      if(array[left] <= array[mid] && array[mid] <= array[right]){
        // do binary search as in nomal array
        return binarySearch(array, left, right, target);
      }
      // shift position lies in left to mid array
      if(array[left] >= array[mid] && array[mid] <= array[right]){
        // 如果target 不在右边array，就去左边找
        // Case 1: target in right array range
        if(array[mid] <= target && target <= array[right]){
          // do binary search as in nomal array
          return binarySearch(array, mid, right, target);
        }
        // Case 2: target in left array if not right array
        right = mid - 1;
      }
      // shift position lies in mid to right array
      if(array[left] <= array[mid] && array[mid] >= array[right]){
        // 如果target 不在左边array，就去右边找
        if(array[left] <= target && target <= array[mid]){
          // do binary search as in nomal array
          return binarySearch(array, left, mid, target);
        }
        left = mid + 1;
      }
    }
    //not found
    return -1;
  }
  
  private int binarySearch(int[] array, int left, int right, int target){
    while(left <= right){
      int mid = left + (right - left) / 2;
        // do binary search as in nomal array
      if(array[mid] == target){
         return mid;
      }
      if(array[mid] > target){
        right = mid - 1;
      }
      else{
        left = mid + 1;
      }
    }
    return -1;
  }
    
}