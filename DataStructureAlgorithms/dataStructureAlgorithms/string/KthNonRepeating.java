package string;

import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.print.DocFlavor.CHAR_ARRAY;

public class KthNonRepeating {
	public static int MAX_CHAR=256;
	
	static int partition(int[] arr, int low, int high){
		int pivot=arr[high]; int i=low-1;
		for(int j=low; j<high; j++){
			if(arr[j]<=pivot){
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		int temp=arr[i+1];
		arr[i+1]=arr[high];
		arr[high]=temp;
		
		return i+1;
	}
	
	static void quicksort(int[] arr, int low, int high){
		if(low<high){
			int pi=partition(arr, low, high);
			
			quicksort(arr, low, pi-1);
			quicksort(arr, pi+1, high);
		}
	}
	
	static int kthNonRepeatingCharacter(String input, int k){
		int[] count=new int[MAX_CHAR];
		int[] index=new int[MAX_CHAR];
		int n=input.length();
		
		for(int i=0; i<MAX_CHAR; i++){
			count[i]=0;
			index[i]=n;
		}
		
		for(int i=0; i<n; i++){
			Character x=input.charAt(i);
			++count[x];
			
			if(count[x]==1)
				index[x]=i;
			else
				index[x]=n;
		}
		quicksort(index,0,index.length-1);
		
		return (index[k-1]!=n)?index[k-1]:-1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input="geeksforgeeks";
		int res=KthNonRepeating.kthNonRepeatingCharacter(input,1);
		if(res==-1)
			System.out.println("Invalid");
		else
			System.out.println(input.charAt(res));
	}

}
