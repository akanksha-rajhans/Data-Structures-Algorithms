package binaryHeap;

/*
 * Construct min heap from first k+1 elememts, extract min
 * store in result array and add new element from array.
 * Continuw this while size of array is greater than 1.
 */

public class SortNearlySortedArray {
	
	int[] sortArray(int[] arr, int k){
		if(arr.length==0)
			return null;
		int[] res=new int[arr.length];
		int i=0; int j=0;
		MinBinaryHeap h=new MinBinaryHeap(k+1, 0);
		for(i=0; i<k+1; i++)
			h.arr[i]=arr[i];
		h.buildHeap(h,h.arr);
		while(i<arr.length && j<arr.length){
			res[j]=h.deleteMin();
			h.insert(arr[i]);
			i++; j++;
		}
		
		while(j<arr.length){
			res[j]=h.deleteMin();
			j++;
		}
		
		return res;
	}
	
	void printArray(int[] res){
		for(int i=0; i<res.length; i++){
			System.out.print(res[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		 int k = 3;
		 int arr[] = {2, 6, 3, 12, 56, 8};
		 SortNearlySortedArray obj=new SortNearlySortedArray();
		 int[] res=obj.sortArray(arr,k);
		 obj.printArray(res);
	}

}
