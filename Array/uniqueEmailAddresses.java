class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<String>();
        for(String s : emails){
            result.add(processedEmail(s));
        }
        return result.size();
    }
    private String processedEmail (String email){
        // better for in-place modification
        char[] array = email.toCharArray();
        int slow = 0, fast = 0;
        // stop at @
        boolean ignore = false;
        while(array[fast] != '@'){
            if (array[fast] == '+'){
                // ignore everything until @
                ignore = true;
            }
            else if(array[fast] != '.' && ignore == false){
                array[slow++] = array[fast];
                
            }
            fast++;
        }
        // now fast is pointing to '@'
        // copy the whole domain name
        while(fast < array.length){
            array[slow++] = array[fast++];
        }
        // here slow is the length of new String
        // thus not slow - 1
        return new String(array, 0, slow);
    }
}