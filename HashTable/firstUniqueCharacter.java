// Time: O(N)
    // Space: O(n)
    // After seeing the LeetCode solution
    public int firstUniqChar(String s) {
        // do a <letter, frequency> HashMap
        // then linear scan the string check if hashMap frequency is 1
        if(s == null || s.length() == 0){
            return -1;
        }
        // O(n)
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            /*
            if(!map.containsKey(c)){
                map.put(c, 1);
            }
            else{
                map.put(c, 1 + map.get(c));
            } */
            // optimize
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // O(n)
        // just do a second linear scan from the string!!!
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }