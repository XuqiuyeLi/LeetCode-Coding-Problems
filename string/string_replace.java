/*
 * Given an original string input, and two strings source and target
 * replace all occurrences of source input with target
 *
 */



public class Solution {
  public String replace(String input, String source, String target) {
    char[] array = input.toCharArray();
    if(source.length() >= target.length()){
      return replaceShorter(array, source, target);
    }
    else{
      return replaceLonger(array, source, target);
    }
  }
  private String replaceShorter(char[] array, String source, String target){
    int slow = 0, fast = 0;
    // two pointers from left to right
    while(fast < array.length){
      if(fast <= array.length - source.length() && equalString(array, fast, source)){
        copySubstring(array, slow, target);
        slow += target.length();
        fast += source.length();
      }
      else{
        array[slow++] = array[fast++];
      }
    }
    return new String(array, 0, slow);
  }
  
  private String replaceLonger(char[] array, String source, String target){
    // all the matching end positions for source in array
    ArrayList<Integer> allMatches = findMatches(array, source);
    char[] result = new char[array.length + allMatches.size() * (target.length() - source.length())];
    int slow = result.length - 1;
    int fast = array.length - 1;
    int lastIndex = allMatches.size() - 1;
    while(fast >= 0){
      if(lastIndex >= 0 && allMatches.get(lastIndex) == fast){
        copySubstring(result, slow - target.length() + 1, target);
        fast -= source.length();
        slow -= target.length();
        lastIndex--;
      }
      else{
        result[slow--] = array[fast--];
      }
    }
    return new String(result);
  }
    
  
  private ArrayList<Integer> findMatches(char[] array, String source){
    ArrayList<Integer> matches = new ArrayList<Integer>();
    int i = 0;
    while(i <= array.length - source.length()){
      if(equalString(array, i, source)){
        matches.add(i + source.length() - 1);
        i += source.length();
      }
      else{
        i++;
      }
    }
    return matches; 
  }
  
  private boolean equalString(char[] array, int index, String source){
    for(int i = 0; i < source.length(); i++){
      if(array[i + index] != source.charAt(i)){
        return false;
      }
    }
    return true;
  }
  private void copySubstring(char[] array, int index, String target){
    for(int i = 0; i < target.length(); i++){
      array[i + index] = target.charAt(i);
    }
  }
}
