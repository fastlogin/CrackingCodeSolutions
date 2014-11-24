
public class Queue {
	SQNode first, last;
	
	public void enqueue(int d){
		if(first == null){
			last = new SQNode(d);
			first = last;
		}
		else{
			last.next = new SQNode(d);
			last = last.next;
		}
	}
	
	public int dequeue(){
		if(first != null){
			first = first.next;
			return first.data;
		}
		return 0;
	}
	
}
