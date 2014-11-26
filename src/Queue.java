
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
			int temp = first.data;
			first = first.next;
			return temp;
		}
		return 0;
	}
	
}
