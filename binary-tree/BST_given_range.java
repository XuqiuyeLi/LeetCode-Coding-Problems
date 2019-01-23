
// Print all BST keys which k1 <= key <= k2

void inOrder(TreeNode root, int lower, int upper){
	if(root == null){
		return;
	}
	else if(root.key > lower){
		inOrder(root.left, lower, upper);
	}
	else if(root.key >= lower && root.key <= upper){
		System.out.println(root.key);
	}
	else if(root.key < upper){
		inOrder(root.left, lower, upper);
	}
}