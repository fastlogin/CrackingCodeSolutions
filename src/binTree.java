
public class binTree {
	
	TreeNode root;
	
	binTree(int d){
		TreeNode r = new TreeNode(d);
		root = r;
	}
	
	void addHelp(int d , TreeNode r){
		if(d < r.data){
			if(r.left == null){
				TreeNode toAdd = new TreeNode(d);
				r.left = toAdd;
				return;
			}
			else{
				addHelp(d,r.left);
			}
		}
		if(d >= r.data){
			if(r.right == null){
				TreeNode toAdd = new TreeNode(d);
				r.right = toAdd;
				return;
			}
			else{
				addHelp(d,r.right);
			}
		}
	}
	
	void add(int d){
		addHelp(d,root);
	}
	
	void preorderHelper(TreeNode r){
		System.out.println(""+r.data);
		if(r.left != null){
			preorderHelper(r.left);
		}
		if(r.right != null){
			preorderHelper(r.right);
		}
	}
	
	void inorderHelper(TreeNode r){
		if(r.left != null){
			inorderHelper(r.left);
		}
		System.out.println(""+r.data);
		if(r.right != null){
			inorderHelper(r.right);
		}
	}
	
	void postorderHelper(TreeNode r){
		if(r.right != null){
			postorderHelper(r.right);
		}
		System.out.println(""+r.data);
		if(r.left != null){
			postorderHelper(r.left);
		}
	}
	
	void preorder(){
		preorderHelper(root);
	}
	
	void inorder(){
		inorderHelper(root);
	}
	
	void postorder(){
		postorderHelper(root);
	}
	
	
	
	public static void main(String[] args){
		
		binTree test = new binTree(200);
		test.add(100);
		test.add(86);
		test.add(25);
		test.add(151);
		test.add(250);
		test.add(252);
		test.preorder();
		
		System.out.println("");
		
		test.inorder();
		
		System.out.println("");
		
		test.postorder();
		
	}
	
	
	
}
