public boolean containsDuplicate(int[] nums) {
        // use Hashset
        // if add() == false, return true
        // else all distinct elements
        Set<Integer> set = new HashSet<Integer>();
        for(int x: nums){
            if(!set.add(x)){
                return true;
            }
        }
        return false;
    }