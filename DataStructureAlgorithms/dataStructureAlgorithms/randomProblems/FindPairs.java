package randomProblems;

/*Give an array A, find the (i, j) pairs that satisfy the condition. 
Condition 1: A [j] = A [i] + 1, Condition 2: j - i is as large as possible 
Follow up condition 1 is changed to A [j]> A [i]*/

public class FindPairs {
	
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
	
	static void sort(int[] arr, int low, int high){
		if(low<high){
			int pi=partition(arr, low, high);
			
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}	
	}

	public static void main(String[] args) {
		int[] arr=new int[]{10,7, 8,9,1,5};
		FindPairs.sort(arr, 0, arr.length-1);
		FindPairs.sort(arr, 0, arr.length-1);
	}

}
