package randomProblems;

import java.util.Arrays;

public class NextGreaterNumber {
	
	void func(char[] arr, int n){
		int i;
		for(i=n-1; i>0; i--){
			if(arr[i-1]<arr[i])
				break;
		}
		if(i==0)
			System.out.println("Not Possible");
		else{
			int x=arr[i-1]; int min=i;
			for(int j=i+1; j<n;j++){
				if(arr[j]>x && arr[j]<arr[min])
					min=j;
			}
			swap(arr,i-1,min);
			Arrays.sort(arr,i,n);
		}
		for(i=0;i<n;i++)
			System.out.print(arr[i]);
	}
	
	void swap(char[] arr, int a, int b){
		char temp=arr[a];
		arr[a]=arr[b];
		arr[b]=temp;
	}

	public static void main(String[] args) {
		NextGreaterNumber ngn=new NextGreaterNumber();
		char[] arr={ '5','3','4','9','7','6' };
		ngn.func(arr,arr.length);

	}

}
