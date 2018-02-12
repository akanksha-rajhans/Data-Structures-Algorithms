package string;

import java.util.*;

public class StringPermutations {
	Set<String> set=new HashSet<>();
	
	public static void main(String[] args) {
		StringPermutations obj= new StringPermutations();
		Set<String> s=obj.printPermutations("ABC", 0, 2);
		for (String str : s) {
			System.out.println(str);
		}
	}

	private Set<String> printPermutations(String str, int l, int r) {
		if(l==r)
			set.add(str);
		else{
			for(int i=l; i<=r; i++){
				str=swap(str,l,i);
				printPermutations(str, l+1, r);
			}
		}
		return set;
	}

	private String swap(String str, int l, int r) {
		char[] arr= str.toCharArray();
		char temp=arr[l];
		arr[l]=arr[r];
		arr[r]=temp;
		return String.valueOf(arr);
		
	}

}
