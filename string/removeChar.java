public class Solution {
  public String remove(String input, String t) {
    if(input.length() == 0 || t.length() == 0){
      return input;
    }
    char[] array = input.toCharArray();
    Set<Character> set = buildSet(t);
    int slow = 0, fast = 0;
    while(fast < array.length){
      if(!set.contains(array[fast])){
        array[slow++] = array[fast++];
      }
      else{
        fast++;
      }
    }
    return new String(array, 0, slow);
  }
  private Set<Character> buildSet(String t){
    Set<Character> set = new HashSet<Character>();
    for(int i = 0; i < t.length(); i++){
      set.add(t.charAt(i));
    }
    return set;
  }
}