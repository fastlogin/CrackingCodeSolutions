import java.util.Arrays;


public class Tree {
	
	int balHelper(int h, Node r){
		if(r == null){
			return h;
		}
		else{
			return Math.max(helper(r.left), helper(r.right));
		}
	}
	
	boolean isBalanced(Node r){
		if(r.left == null && r.right == null){
			return true;
		}
		
		else{
			return(helper(1,r.left)-helper(1,r.right) <= 1 && (isBalanced(r.left) && isBalanced(r.right)));
		}
	}
	
	boolean isRoute(Node curr, Node end){
		if(curr == end){
			return true;
		}
		
		if(curr != end && curr.next == null){
			return false;
		}
		return isRoute(curr.next, end);
		
	}
	
	Node makeBST (int[] input){
		if(input.length == 1){
			Node res = new Node(input[0],null,null);
			return res;
		}
		
		else{
			Node res = new Node(
								input[input.length/2],
								makeBST(Arrays.copyOfRange(input,0,input.length/2 - 1)),
								makeBST(Arrays.copyOfRange(input, input.length/2 + 1, input.length-1)));
		}
	}
	
	//LinkedList of nodes @ depth?
	//Recursively go through tree and make each call with a depth, store nodes in a HashTable
	//with keys being the depth, nodes of same depth will be stored at same bucket.
	//Have hash buckets in the form of Linked Lists, return buckets as answers.
	
	boolean bstHelper(Node r, int least, int greatest){
		if(r == null){
			return true;
		}
		
		if(r.data < greatest && r.data > least && r.left == null && r.right == null){
			return true;
		}
		
		else{
			return (r.data < greatest && r.data > least) &&
					bstHelper(r.left,least,r.data) &&
					bstHelper(r.right,r.data,greatest);
		}
	}
	
	boolean isBST(Node r){
		return bstHelper(r,<minvalue>,<maxvalue>);
	}
	
	
	
	
}
