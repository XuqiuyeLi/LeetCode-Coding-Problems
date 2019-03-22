public class Solution {
  // Time: O(1), Space: O(n)
  // S1 is for keeping all the elements
  // S2 is for storing the min so far in S1 (as its top element)
  private Deque<Integer> stack;
  private Deque<Integer> minStack;
  
  public Solution() {
    stack = new LinkedList<Integer>();
    minStack = new LinkedList<Integer>();
  }
  
  public int pop() {
    if(stack.isEmpty()){
      return -1;
    }
    int result = stack.pollFirst();
    if(minStack.peekFirst() == result){
      minStack.pollFirst();
    }
    return result;
  }
  
  public void push(int element) {
    stack.offerFirst(element);
    // while value <= current min value in the stack
    // !!! important, < = 
    if(minStack.isEmpty() || element <= minStack.peekFirst()){
      minStack.offerFirst(element);
    }
  }
  
  public int top() {
    if(stack.isEmpty()){
      return -1;
    }
    return stack.peekFirst();
  }
  
  public int min() {
    if(minStack.isEmpty()){
      return -1;
    }
    // remember here is to return peek
    return minStack.peekFirst();
  }
}