class Solution {
    
    // Time: O(N), but Space: O(N)
    // One time pass
    // Used 10 min
    private int singleNumber1(int[] nums) {
        // Assume not null or empty
        if(nums.length == 1){
            return nums[0];
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int x : nums){
            // if alread exists, then remove
            if(set.contains(x)){
                set.remove(x);
            }
            else{
            // if not, then add to the set
                set.add(x);
            }
        }
        for(int x : nums){
            if(set.contains(x)){
                return x;
            }
        }
        return -1;
    }
    
    // solution: if we sort first, then time O(NlogN), space O(1)
    // optimized solution XOR!!!!! 
    // checked discussion for this one, didn't come to me immediately
    // Time O(n), Space O(1)
    public int singleNumber(int[] nums){
        for(int i = 1; i < nums.length; i++){
            nums[0] ^= nums[i];
        }
        return nums[0];
    }
}