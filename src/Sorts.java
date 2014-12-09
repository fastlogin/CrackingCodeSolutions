import java.util.Arrays;


public class Sorts {
	
	static void print(int[] input){
		int i = 0;
		String res = "";
		while(i < input.length){
			res += input[i];
			res += " ";
			i++;
		}
		System.out.println(""+res);
	}
	
	static void bubble(int[] input){
		int place = input.length-1;
		while(place > 0){
			for(int i = 1 ; i <= place; i++){
				int j = i - 1;
				if(input[j] > input[i]){
					int temp = input[i];
					input[i] = input[j];
					input[j] = temp;
				}
			}
			place --;
		}
	}
	
	static void selection(int[] input){
		int place = 0;
		int minplace = 0;
		int min;
		while(place < input.length){
			min = 1000;
			for(int i = place; i < input.length; i++){
				if(input[i] < min){
					min = input[i];
					minplace = i;
				}
			}
			int temp = input[place];
			input[minplace] = temp;
			input[place] = min;
			place++;
		}
	}
	
	static int[] merge(int[] input1, int[] input2){
		int[] result = new int[input1.length + input2.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(i < result.length-1){
			System.out.println(""+i);
			System.out.println(""+j);
			System.out.println(""+k);
			if(input1[j] <= input2[k]){
				result[i] = input1[j];
			    i++;
				j++;
			}
			else if(input1[j] > input2[k]){
				result[i] = input2[k];
				i++;
				k++;
			}
			if(j == input1.length){
				for(int l = k ; l < input2.length ; l++){
					result[i] = input2[l];
					i++;
				}
				return result;
			}
			if(k == input2.length){
				for(int l = j ; l < input1.length ; l++){
					result[i] = input1[l];
					i++;
				}
				return result;
			}
		}
		
		return result;
	}
	
	static int[] mergeSort(int[] input){
		if(input.length == 1){
			return input;
		}
		else{
			int part = input.length / 2  ;
			return merge(mergeSort(Arrays.copyOfRange(input, 0, part)),
						 mergeSort(Arrays.copyOfRange(input, part, input.length)));
		}
		
	}
	
	static void quickHelper(int[] input, int start, int end){
		if(start == end){
			return;
		}
		if(end == start + 1){
			if(end < start){
				int temp = input[end];
				input[end] = input[start];
				input[start] = temp;
				return;
			}
		}
		int i = start;
		int j = end;
		int pivot = input[input.length/2];
		while(i != j ){
			System.out.println("i: " + i + ", j: " + j);
			while(input[i] < pivot && i <= end   ){
				i++;
			}
			while(input[j] > pivot && j >= start){
				j--;
			}
			int temp = input[i];
			input[i] = input[j];
			input[j] = temp;
		}
		quickHelper(input,start,i-1);
		quickHelper(input,i+1,end);
	}
	
	static void quickSort(int[] input){
		quickHelper(input,0,input.length -1);
	}
	
	public static void main (String[] args){
		int[] test = {100,3,4,1,2,6,5,11,7};
	    quickSort(test);
		print(test);
	}

}
