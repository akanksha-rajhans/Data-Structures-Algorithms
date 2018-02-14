package binaryHeap;

//O(klogn)
public class kLargestElement {
	
	int findKthLargestElement(int[] arr, int k){
		if(arr.length<=0)
			return -1;
		int count=0; int kMax=Integer.MIN_VALUE;
		MaxBinaryHeap h=new MaxBinaryHeap(1, arr.length);
		h.buildHeap(h, arr);
		while(count<k){
			kMax=h.deleteMax();
			count++;
		}
		return kMax;
	}
	
	public static void main(String[] args) {
		kLargestElement obj=new kLargestElement();
		int arr[] = new int[]{6, 2, 4, 5, 3, 7, 1};
		int k = 3;
		System.out.println(k+" largest element is "+obj.findKthLargestElement(arr,k));
	}

}
