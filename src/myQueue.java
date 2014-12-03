
public class myQueue {
	
	Stack front;
	Stack back;
	
	public myQueue(int d){
		front = new Stack();
		back = new Stack();
		
		front.push(d);
		back.push(d);
	}
	
	public void enqueue(int d){
		Stack temp = new Stack();
		temp.push(d);
		back.push(d);
		while(front.top != null){
			temp.push(front.pop());
		}
		front = temp;
	}
	
	public int dequeue(){
		Stack temp = new Stack();
		Stack temp2 = front;
		while(temp2.top.next != null){
			temp.push(temp2.pop());
		}
		return front.pop();
	}

	public static void main(String[] args){
		
	}
}
