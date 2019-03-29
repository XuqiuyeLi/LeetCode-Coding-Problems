class Solution {
    /*
    public void sortColors1(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        // three pointers
        int left = 0; //[0, left) are 0s
        int right = nums.length - 1; // (right, end] are 2s
        int i = 0;
        // while loop condition??
        while(i <= right){
            if(nums[i] == 0){
                swap(nums, left, i);
                left++;
                i++;
            }
            else if(nums[i] == 2){
                swap(nums, i, right);
                right--;
                //只有right update的时候，i不变，因为还没有process过right swap过来的element
            }
            // 这里很重要！
            else{
                i++;
            }
        }
    }
     */
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1){
            return;
        }
        int left = 0;
	    int right = nums.length - 1;
	    int current = 0;
	    while(current <= right) {
		    if(nums[current] == 0){
			    swap(nums, left, current);
			    left++;
			    current++;
		    }
		    else if(nums[current] == 1) {
			    current++;
		    }
		    else {
			    swap(nums, right, current);
			    right--;
		    }
	    }
    }
    private void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
