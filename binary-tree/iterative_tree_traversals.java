  public List<Integer> preOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if(root == null){
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    stack.offerFirst(root);
    while(!stack.isEmpty()){
      TreeNode cur = stack.pollFirst();
      if(cur.right != null){
        stack.offerFirst(cur.right);
      }
      if(cur.left != null){
        stack.offerFirst(cur.left);
      }
      result.add(cur.key);
    }
    return result;
  }



  public List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if(root == null){
      return result;
    }
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    TreeNode cur = root;
    while(cur != null || !stack.isEmpty()){
      // go to the left child of cur to see if any more nodes should be traversed first
      if(cur != null){
        stack.offerFirst(cur);
        cur = cur.left;
      }else{
        // reach the end of the left subtree
        cur = stack.pollFirst();
        result.add(cur.key);
        cur = cur.right;
      }    
    }
    return result;
  }



  public List<Integer> postOrder(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    if(root == null){
      return result;
    }
    Deque<TreeNode> preOrder = new LinkedList<TreeNode>();
    preOrder.offerFirst(root);
    while(!preOrder.isEmpty()){
      TreeNode cur = preOrder.pollFirst();
      // post-order is the reverse order of pre-order 
      // with traversing right subtree before left subtree
      result.add(cur.key);
      // add the cur key first
      if(cur.left != null){
        preOrder.offerFirst(cur.left);
      }
      if(cur.right != null){
        preOrder.offerFirst(cur.right);
      }
    }
    // reverse the pre-order traversal to get post order result
    Collections.reverse(result);
    return result;
  }