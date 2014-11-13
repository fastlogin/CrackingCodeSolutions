import java.util.*;


public class StringsandArrays {
	
	public static boolean uniqueString(String input){
		HashSet<Character> temp = new HashSet<Character>();
		int time = 0;
		for(int i = 0 ; i < input.length() ; i ++){
			temp.add(input.charAt(i));
			time = i+1;
		}
		System.out.println(""+time);
		return temp.size() == input.length();
		
	}
	
	public static boolean uniqueString2(String input){
		HashMap<Character, Integer> temp = new HashMap<Character, Integer>();
		int time = 0;
		for(int i = 0 ; i < input.length() ; i++){
			if(temp.containsKey(input.charAt(i))){
				System.out.println(""+i+1);
				return false;
			}
			temp.put(input.charAt(i), 420);
			time = i+1;
		}
		System.out.println(""+time);
		return true;
		
	}
	
	public static String reverseString(String input){
		String temp = "";
		for(int i = input.length()-1 ; i >= 0 ; i--){
			temp += input.charAt(i);
		}
		return temp;
	}
	
	public static boolean isPerm(String a, String b){
		int count1 = 0;
		int count2 = 0;
		HashSet<Character> temp =  new HashSet<Character>();
		for(int i = 0;  i < a.length(); i++){
			temp.add(a.charAt(i));		
		}
		count1 = temp.size();
		for(int i = 0; i < b.length(); i++){
			temp.add(b.charAt(i));
		}
		count2 = temp.size();
		return((a.length() == b.length())&&(count1 == count2));
	}
	
	/*
	public static void replace(char[] a){
		for(int i = 0; i < a.length; i++){
			if (a[i] == ' '){
				for(int k = i+3; k < a.length ; k++){
					a[k+1]
				}
			}
		}
	}*/
	
	public static String compress(String input){
		
		int i = 0;
		int tempCount = 1;
		String temp = "" + input.charAt(0);
		while(tempCount < input.length()){
			System.out.println(temp);
			System.out.println(""+i);
			System.out.println(""+tempCount);
			if(temp.charAt(i) == input.charAt(tempCount)){
				int count = 2;
				if(tempCount == input.length()-1){
					return temp += count;
				}
				for(int k = tempCount+1 ; k < input.length(); k++){
					if(k == input.length()-1 && (temp.charAt(i) == input.charAt(k))){
						temp += (count+1);
						return temp;
					}
					else if(temp.charAt(i) == input.charAt(k)){
						count++;
					}
					else{
						temp += count;
						temp += input.charAt(k );
						break;
					}
				}
				tempCount += (count);
				i+=2;

				
			}
			else{
				temp += input.charAt(tempCount);
				i++;
				tempCount++;
	
			}
		}
		return temp;
	}
	
	
	
	public static void main(String [ ] args){
		/**
		boolean first = uniqueString("hehyuhjklb");
		boolean second = uniqueString("qwertyuiopasdfghjklzxcvbnm");
		System.out.println(""+first);
		System.out.println(""+second);
		boolean third = uniqueString2("hehyuhjklb");
		boolean fourth = uniqueString2("qwertyuiopasdfghjklzxcvbnm");
		System.out.println(""+third);
		System.out.println(""+fourth);
		String rev1 = reverseString("artra");
		String rev2 = reverseString("kennethlee");
		System.out.println(rev1);
		System.out.println(rev2);
		**/
		/*
		boolean perm1 = isPerm("a","a");
		System.out.println(""+perm1);
		boolean perm2 = isPerm("aaa","aaaaa");
		System.out.println(""+perm2);
		boolean perm3 = isPerm("bad","sad");
		System.out.println(""+perm3);
		boolean perm4 = isPerm("yuiope","epyuio");
		System.out.println(""+perm4);*/
		String juice = compress("helleeeed");
		System.out.println(juice);
		
		
	}


}
