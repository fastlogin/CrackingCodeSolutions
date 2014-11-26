
public class Stack {
	
	SQNode top;
	int size = 0;
	
	public int pop(){
		if (top != null){
			int temp = top.data;
			top = top.next;
			size--;
			return temp;
		}
		return 0;
	}
	
	public void push(int d){
		SQNode toAdd = new SQNode(d);
		toAdd.next = top;
		top = toAdd;
		size++;
	}
	
	public int peek(){
		return top.data;
	}
	
	

}