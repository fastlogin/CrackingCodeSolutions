
public class Stack {
	
	SQNode top;
	
	public int pop(){
		if (top != null){
			int temp = top.data;
			top = top.next;
			return temp;
		}
		return 0;
	}
	
	public void push(int d){
		SQNode toAdd = new SQNode(d);
		toAdd.next = top;
		top = toAdd;
	}
	
	public int peek(){
		return top.data;
	}
	
	

}