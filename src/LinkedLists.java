import java.util.*;

//@ Chapter 2: Linked Lists
//@ 11/14/2014
//@ George Ding

public class LinkedLists {
	
	public static void removeDuplicates(LinkedList input){
		LinkedList counter = input.getHead();
		while(counter.getNext() != null){
			if(counter.getNext().getData() == counter.getData()){
				LinkedList lastDupe = counter.getNext();
				while(lastDupe != null && lastDupe.getData() == counter.getData()){
					lastDupe = lastDupe.getNext();
				}
				counter.setNext(lastDupe);
			}
			else{
				counter = counter.getNext();
			}
		}
	}
	
	public static void kthFromEnd(LinkedList input, int k){
		if(k >= input.getLength()){
			return;
		}
		int pointBuffer = k;
		LinkedList kPointer = input.getHead();
		LinkedList pointer = input.getHead();
		while(pointBuffer > 0){
			kPointer = kPointer.getNext();
			pointBuffer--;
		}
		while(kPointer != null){
			if(kPointer.getNext() == null){
				System.out.println(""+ pointer.getData());
				return;
			}
			kPointer = kPointer.getNext();
			pointer = pointer.getNext();
		}
	}
	
	public static void removeMiddle(LinkedList middle){
		middle = middle.getNext();
	}
	
	public static void main(String[] args){
		LinkedList test = new LinkedList(0);
		test.addTail(1);
		test.addTail(2);
		test.addTail(2);
		test.addTail(3);
		test.addTail(4);
		test.addTail(4);
		test.addTail(4);
		test.addTail(5);
		test.addTail(6);
		test.addTail(7);
		test.addTail(7);
		test.addTail(9);
		test.print();
		removeDuplicates(test);
		test.print();
		kthFromEnd(test,8);
		removeMiddle(test.getHead());
		test.print();
	}

}
