class Solution {
    // LeetCode solution
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
    // My solution: if also contains Unicode
    // Time: O(n)
    // Space: O(n)
    public boolean isAnagram(String s, String t) {
        
        // throw the first string into HashMap
        // using the second string to remove from HashMap
        // if the Hash Map is empty at the end, then true, else false
        
        // corner case length not match, null, empty
        if((s == null && t == null) || (s.length() == 0 && t.length() == 0)){
            return true;
        }       
        if(s == null || t == null || s.length() != t.length()){
            return false;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        // add all char from s to map
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // delete all char in t from map
        for(int j = 0; j < t.length(); j++){
            char l = t.charAt(j);
            if(!map.containsKey(l)){
                return false;
            }
            if(map.get(l) == 1){
                map.remove(l);
            }
            else{
                map.put(l, map.get(l) - 1);
            }
        }
        return map.isEmpty();
    }
    // Solution 2: sorting
    // Time: O(nlogn)
    // Space: O(1)
    // Space depends on the sorting implementation which, usually, costs O(1) auxiliary space if heapsort is used. Note that in Java, toCharArray() makes a copy of the string so it costs O(n)extra space, but we ignore this for complexity analysis because: 
    // 1. It is a language dependent detail.
    // 2. It depends on how the function is designed. For example, the function parameter types can be changed to char[].
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}