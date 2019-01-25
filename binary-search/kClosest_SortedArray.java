public class KClosest{
	public int[] kClosest(int[] array, int target, int k){
		if(array == null || array.length == 0){
			return array;
		}
		if(k == 0){
			return new int[0];
		}
		// left is the index of the largest smaller or equal element,
		// right = left + 1.
		// these two should be the closest to target
		int left = largestSmallerEqual(array, target);
		int right = left + 1;
		int[] result = new int[k];
		// this is a typical merge operation
		for(int i = 0; i < k; i++){
			if(right >= array.length || left >= 0 && target - array[left] <= array[right] - target){
				result[i] = array[left--];
			}else{
				result[i] = array[right++];
			}
		}
		return result;
	}

	private int largestSmallerEqual(int[] array, int target){
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1){
			int mid = left + (right - left) / 2;
			if(array[mid] <= target){
				left = mid;
			}else{
				right = mid;
			}
		}
		if(array[right] <= target){
			return right;
		}
		if(array[left] <= target){
			return left;
		}
		// can not find
		return -1;
	}
}