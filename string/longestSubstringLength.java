class Solution {
    public int lengthOfLongestSubstring(String s) {
        // sliding window question
        int slow = 0; 
        int fast = 0;
        int max = 0; // record the global max
        Set<Character> set = new HashSet<Character>();
        // all the letters within sliding window slow and fast should be unique
        while (fast < s.length()){
            if(set.contains(s.charAt(fast))){
                // we need to move slow until it becomes distinct again
                set.remove(s.charAt(slow));
                slow++;
            }
            else{ // all the distinct char now
                set.add(s.charAt(fast));
                fast++;
                max = Math.max(max, fast - slow);
            }
        }
        return max;
    }
}