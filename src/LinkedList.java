import java.util.*;

public class LinkedList {
	
	private int data;
	private int length;
	private LinkedList next;
	private LinkedList head;
	private LinkedList tail;
	
	public LinkedList(int d){
		data = d;
		next = null;
		head = this;
		tail = this;
	}
	
	public int getData(){
		return this.data;
	}
	
	public LinkedList getTail(){
		return this.tail;
	}
	
	public LinkedList getHead(){
		return this.head;
	}
	
	public LinkedList getNext(){
		return this.next;
	}
	
	public void setNext(LinkedList d){
		this.next = d;
	}
	
	public int getLength(){
		int length = 0;
		LinkedList counter = this.head;
		while(counter != null){
			length++;
			counter = counter.next;
		}
		return length;
	}
	
	public LinkedList getNode(int a){
		if (a > this.getLength()) {
			return null;
		}
		LinkedList counter = this.head;
		while(a > 1){
			counter = counter.getNext();
			a--;
		}
		return counter;
	}
	
	public void addTail(int d){
		LinkedList toAdd = new LinkedList(d);
		this.getTail().next = toAdd;
		this.tail = this.getTail().next;
	}
	
	public void addHead(int d){
		LinkedList toAdd = new LinkedList(d);
		toAdd.next = this.head;
		this.head = toAdd;
	}

	public void removeHead(){
		this.head = this.head.getNext();
		return;
	}
	
	public void removeTail(){
		LinkedList counter = this.head;
		LinkedList counter2 = counter.getNext();
		while(counter2 != null){
			if(counter2.getNext() == null){
				counter.next = null;
				this.tail = counter;
				return;
			}
		}
	}
	
	public void remove(int d){
		int count = 0;
		LinkedList counter = this.head;
		LinkedList counter2 = counter.getNext();
		while(counter2 != null){
			if(count == 0 && counter.getData() == d){
				this.removeHead();
			}
			if(counter2.getData() == d){
				if(count == this.getLength()-1){
					counter.next = null;
					this.tail = counter;
					return;
				}
				counter.next = counter2.next;
				counter2 = null;
				return;
			}
			count++;
			counter = counter.next;
			counter2 = counter2.next;
			}
	}
	
	
	public void print(){
		String result = "";
		LinkedList counter = this.head;
		while(counter != null){
			result += counter.getData();
			result += " ";
			counter = counter.next;
		}
		System.out.println(result);
	}
	
	public static void main(String[] args){
		LinkedList test = new LinkedList(0);
		test.addTail(3);
		test.addTail(4);
		test.addTail(5);
		test.addTail(6);
		test.addTail(1);
		test.print();
		test.addHead(1);
		test.print();
		test.remove(3);
		test.print();
		test.remove(1);
		test.print();
		test.remove(1);
		test.print();
	}
	

}
