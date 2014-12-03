
public class TreeNode {
	
	int data;
	TreeNode left;
	TreeNode right;
	
	TreeNode(int d){
		data = d;
		left = null;
		right = null;
	}
	
	TreeNode(int d, TreeNode l, TreeNode r){
		data = d;
		left = l;
		right = r;
	}
	
}
