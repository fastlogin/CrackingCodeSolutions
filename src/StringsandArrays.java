import java.util.*;
//@ Chapter 1: Strings and Arrays
//@ 11/13/2014
//@ George Ding

public class StringsandArrays {
	
	/**
	 * Checks if a string has all unique characters using a HashSet.
	 * Function runs string through a HashSet and checks if the HashSet
	 * has the same length as the string at the end. 
	 * @Time: O(N) | Best: O(N) | Worst: O(N)
	 * @Space: O(N)
	 */
	public static boolean uniqueString(String input){
		HashSet<Character> temp = new HashSet<Character>();
		for(int i = 0 ; i < input.length() ; i ++){
			temp.add(input.charAt(i));
		}
		return temp.size() == input.length();
		
	}
	
	/**
	 * Second uniqueString function. Checks if a string has all unique characters 
	 * using a HashMap. Function runs string through a HashMap and checks if there
	 * are any duplicates along the way.
	 * @Time: O(N) | Best: O(1) | Worst: O(N)
	 * @Space: O(N)
	 */
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
	
	public static void quickSort(char[] input){
		if(input.length == 1){
			return;
		}
		int pivot = input.length / 2;
		int point1 = 0;
		int point2 = input.length;
		while(point1 < point2 && (point1 < input.length && point2 >= 0)){
			if(input[point1] > input[pivot] && input[point2] < input[pivot]){
				char temp = input[point2];
				input[point2] = input[point1];
				input[point1] = temp;
				point1++;
				point2--;
			}
			else if(input[point1] <= input[pivot]){
				point1++;
			}
			if(input[point2] > input[pivot]){
				point2--;
			}
		}
	}
	
	public static boolean uniqueString3(char[] input){
		
	}
	/**
	 * Reverses a string.
	 * @Time: O(N) | Best: O(N) | Worst: O(N)
	 * @Space: O(N)
	 */
	public static String reverseString(String input){
		String temp = "";
		for(int i = input.length()-1 ; i >= 0 ; i--){
			temp += input.charAt(i);
		}
		return temp;
	}
	
	/**
	 * Checks if a string is a permutation of another using a single
	 * data structure. Runs both strings into a HashSet.
	 * @Time: O(N) | Best: O(N) | Worst: O(N)
	 * @Space: O(N)
	 */
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
	
	/**
	 * Replaces the spaces of a string with 20% but assumes that the
	 * string is an array with enough space to fit the extra characters.
	 * @Time: O(N) | Best: O(N) | Worst: O(N)
	 * @Space: O(N)
	 */
	public static void replace(char[] a){
		int i = 0;
		while(i < a.length){
			System.out.println(""+ i);
			if (a[i] == ' '){
				for(int k = a.length-1; k > i+1 ; k--){
					a[k] = a[k-2]; 
				}
				a[i] = '2';
				a[i+=1] = '0';
				a[i+=1] = '%';
				i++;		
			}
			else{
				i++;

			}
		}
	}
	
	/**
	 * Replaces the spaces of a string with 20% but assumes that the
	 * string is an array with enough space to fit the extra characters.
	 * @Time: O(N) | Best: O(N) | Worst: O(N)
	 * @Space: O(N)
	 */
	public static String compress(String input){
		int i = 0;
		int tempCount = 1;
		String temp = "" + input.charAt(0);
		while(tempCount < input.length()){
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
	
	/**
	 * Function to print a matrix to help with testing.
	 */
	public static void printMatrix(int[][] input){

        for (int i = 0; i < input.length; i++) {
    		String result = "";
            for (int j = 0; j < input[0].length; j++) {
            	result += input[i][j];
            	result += " ";
            }
            System.out.println(result);
        }
        System.out.println();
          
	}
	
	/**
	 * Function to transpose a matrix.
	 */
    private static void transpose(int[][] input) {

        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input[0].length; j++) {
                int x = input[i][j];
                input[i][j] = input[j][i];
                input[j][i] = x;
            }
        }
    }
	
	/**
	 * Function to swap the rows of a matrix.
	 */
	public static void swapRows(int[][] input) {
	    for (int  i = 0, k = input.length - 1; i < k; ++i, --k) {
	        int[] x = input[i];
	        input[i] = input[k];
	        input[k] = x;
	    }
	}

	/**
	 * Takes a square matrix and rotates it 90 degrees CW.
	 * @Time: O(N2) | Best: O(N2) | Worst: O(N2)
	 * @Space: O(N)
	 */
	public static void rotate90(int[][] input) {
	    swapRows(input);
	    transpose(input);
	}
	
	/**
	 * Takes a square matrix finds every entry that has 0 and replaces
	 * the row and column at that entry with 0.
	 * @Time: O(N2) | Best: O(N2) | Worst: O(N2)
	 * @Space: O(N)
	 */
	public static void replaceWithZero(int[][] input){
		ArrayList<Integer> coors = new ArrayList<Integer>();
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
            	if (input[i][j] == 0){
            		coors.add(i);
            		coors.add(j);
            	}
            }
        }
        for(int k = 1; k < coors.size(); k+=2){
        	for(int l = 0; l < input.length ; l++){
        		input[coors.get(k-1)][l] = 0;
        		input[l][coors.get(k-1)] = 0;
        	}
        }
	}
	
	/**
	 * Function to check if a string is a substring of another string.
	 */
	public static boolean isSubstring(String a, String b){
		System.out.println(a);
		System.out.println(b);
		int start = a.indexOf(b.charAt(0));
		if(start == -1 || b.length() > a.length()){
			return false;
		}
		int k = 0;
		int i = start;
		while(i < a.length() && k < b.length()){
			if(a.charAt(i) != b.charAt(k)){
				return false;
			}
			i++;
			k++;
		}
		return true;
	}

	/**
	 * Checks if a string is a rotation of another string.
	 * (Will write out solution with single call to issubString later.)
	 * @Time: O(N2) | Best: O(N2) | Worst: O(N2)
	 * @Space: O(N)
	 */
	public static boolean isRotation(String a, String b){
		for(int i = 0 ; i < a.length()-1 ; i ++){
			if((b.charAt(i) == a.charAt(a.length()-1))&&(b.charAt(i+1)==a.charAt(0))){
				return (isSubstring(a,b.substring(0,i+1)) && isSubstring(a,b.substring(i+1)));  
			}
		}
		return false;
	}
	
	
	
	public static void main(String [ ] args){
		
		/** Writing tests soon.
		char[] replaceTest1 = new char[10];
		replaceTest1[0] = 'a';
		replaceTest1[1] = 'b';
		replaceTest1[2] = ' ';
		replaceTest1[3] = 'd';
		replaceTest1[4] = 'e';
		replaceTest1[5] = ' ';
		replace(replaceTest1);
		System.out.println(replaceTest1);
		
		int[][] matrixTest1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		printMatrix(matrixTest1);
		rotate90(matrixTest1);
		printMatrix(matrixTest1);
		
		int[][] matrixTest2 = {{1,2,3},{5,0,7},{9,10,11}};
		replaceWithZero(matrixTest2);
		printMatrix(matrixTest2);
		**/
		
	}


}
