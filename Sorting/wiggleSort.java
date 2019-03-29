class Solution {
    public void wiggleSort(int[] nums) {
        // Solution:
        // 1. Sort
        // 2. Swap pairwise starting from 2nd
        Arrays.sort(nums);
        for(int i = 1; i < nums.length - 1; i+= 2){
            swap(nums, i, i + 1);
        }
    }
    private void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}