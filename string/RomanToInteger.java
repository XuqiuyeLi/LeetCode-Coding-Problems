class Solution {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        buildMap(map);
        int result = 0;
        int i = 0;
        while(i < s.length() - 1){
            String temp = s.substring(i, i + 2);
            // move 1 
            if(!map.containsKey(temp)){
                result += map.get(s.substring(i, i + 1));
                i++;
            }
            // move 2
            else{
                result += map.get(temp);
                i += 2;
            }
            
        }
        // check the last character if left
        if(i == s.length() - 1){
            result += map.get(s.substring(i, i + 1));;
        }
        return result;
    }
    
    private void buildMap(Map<String, Integer> map){
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }
}