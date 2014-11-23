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
	
	public static void partition(LinkedList input, int val){
		LinkedList counter = input.getHead();
		LinkedList counter2 = input.getHead().getNext();
		int count = 0;
		if(counter.getData() <= val){
			int temp = counter.getData();
			input.removeHead();
			input.addHead(temp);
		}
		else{
			int temp = counter.getData();
			input.removeHead();
			input.addTail(temp);
		}
		while(count < input.getLength()){
			if(counter2.getData() <= val){
				LinkedList temp = counter2;
				counter.setNext(counter2.getNext());
				input.addTail(temp.getData());
				counter = counter.getNext();
				counter2 = counter.getNext().getNext();
				count+=2;		
			}
			else{
				LinkedList temp = counter2;
				counter.setNext(counter2.getNext());
				input.addHead(temp.getData());
				counter = counter.getNext();
				counter2 = counter.getNext().getNext();
				count+=2;	
			}
			
		}
	}
	
	public static int add(LinkedList input1, LinkedList input2){
		int digit = 1;
		int result = 0;
		LinkedList count1;
		LinkedList count2;
		if(input1.getLength() > input2.getLength()){
			count1 = input2.getHead();
			count2 = input1.getHead();
		}
		else{
			count1 = input1.getHead();
			count2 = input2.getHead();
		}
		while(count1 != null){
			result += count1.getData() * digit + count2.getData() * digit;
			count1 = count1.getNext();
			count2 = count2.getNext();
			digit = digit * 10;
		}
		while(count2 != null){
			result += count2.getData() * digit;
			count2 = count2.getNext();
			digit = digit * 10;
		}
		return result;
	}
	
	public static int add2(LinkedList input1, LinkedList input2){
		int result = 0;
		LinkedList count1;
		LinkedList count2;
		if(input1.getLength() > input2.getLength()){
			count1 = input2.getHead();
			count2 = input1.getHead();
		}
		else{
			count1 = input1.getHead();
			count2 = input2.getHead();
		}
		int digit = (count1.getLength()-1) * 10;
		int digit2 = (count2.getLength()-1) * 10;
		while(count1 != null){
			result += count1.getData() * digit + count2.getData() * digit2;
			count1 = count1.getNext();
			count2 = count2.getNext();
			digit = digit / 10;
			digit2 = digit2 / 10;
		}
		while(count2 != null){
			result += count2.getData() * digit2;
			count2 = count2.getNext();
			digit2 = digit2 / 10;
		}
		return result;
	}
	
	public static boolean isPalindrome(LinkedList input){
		int fHalfEnd;
		int sHalfStart;
		if(input.getLength() == 1){
			return true;
		}
		if(input.getLength() == 2){
			return false;
		}
		if(input.getLength()%2 == 1){
			fHalfEnd = input.getLength()/2 + 1;
			
		}
		else{
			fHalfEnd = input.getLength()/2;
		}
		int[] fHalf = new int[fHalfEnd];
		sHalfStart = input.getLength()/2 + 1;
		int[] sHalf = new int[fHalfEnd];
		int i = 0;
		int j = fHalfEnd - 1;
		LinkedList counter1 = input.getHead();
		LinkedList counter2 = input.getNode(sHalfStart);
		while(i < fHalfEnd){
			fHalf[i] = counter1.getData();
			counter1 = counter1.getNext();
			i++;
		}
		while(j >= 0){
			sHalf[j] = counter2.getData();
			counter2 = counter2.getNext();
			j--;
		}
		return Arrays.equals(fHalf, sHalf);
	}
	
	public static void main(String[] args){
		
		//Testing for removeDuplicates
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
		
		//Testing for kthFromEnd
		kthFromEnd(test,8);
		
		//Testing for partition
		partition(test, 7);
		test.print();
		
		//Testing for add1 and add2
		LinkedList add1 = new LinkedList(1);
		add1.addTail(2);
		LinkedList add2 = new LinkedList(9);
		add2.addTail(6);
		int ans = add2(add1,add2);
		System.out.println(""+ans);
		
		//Testing for isPalindrome
		test.print();
		test.removeHead();
		LinkedList palindrome = new LinkedList(0);
		palindrome.addTail(1);
		palindrome.addTail(1);
		palindrome.addTail(2);
		palindrome.addTail(1);
		palindrome.addTail(1);
		palindrome.addTail(0);
		LinkedList notPalindrome = new LinkedList(2);
		notPalindrome.addTail(1);
		notPalindrome.addTail(1);
		notPalindrome.addTail(1);
		System.out.println(""+isPalindrome(palindrome));
		System.out.println(""+isPalindrome(notPalindrome));
		
	}

}
