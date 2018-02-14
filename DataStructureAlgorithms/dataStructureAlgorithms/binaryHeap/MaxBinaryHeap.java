package binaryHeap;

/*
 * Heaps are implemented here using array. Can be represented as almost complete binary tree 
 * with all the leaf nodes at level h or h-1, h->height.
 * */

public class MaxBinaryHeap {
	int[] arr;
	int count;
	int capacity;
	int heap_type;
	
	public MaxBinaryHeap(int heap_type, int capacity){
		this.capacity=capacity;
		this.arr=new int[this.capacity];
		this.count=0;
		this.heap_type=heap_type;
	}
	
	public int parent(int i){
		if(i<=0 || i>=this.count)
			return -1;
		return (i-1)/2; 
	}
	
	public int leftChild(int i){
		int left=(2*i)+1;
		if(left>=this.count)
			return -1;
		return left;
	}
	
	public int rightChild(int i){
		int right=(2*i)+2;
		if(right>=this.count)
			return -1;
		return right;
	}
	
	public int getMaximum(){
		if(this.count==0)
			return -1;
		return this.arr[0];
	}
	
	public void percolateDown(int i){
		int l, r, max, temp;
		l=leftChild(i);
		if(l!=-1 && this.arr[l]>this.arr[i])
			max=l;
		else
			max=i;
		r=rightChild(i);
		if(r!=-1 && this.arr[r]>this.arr[max])
			max=r;
		
		if(max!=i){
			temp=this.arr[i];
			this.arr[i]=this.arr[max];
			this.arr[max]=temp;
			percolateDown(max);
		}
	}
	
	public int deleteMax(){
		if(this.count==0)
			return -1;
		int ret=this.arr[0];
		this.arr[0]=this.arr[this.count-1];
		this.count--;
		percolateDown(0);
		return ret;
	}
	
	public void insert(int data){
		if(this.count==this.capacity)
			return;
		this.count++;
		int i=this.count-1;
		while(i>=0 && data>this.arr[(i-1)/2]){
			this.arr[i]=this.arr[(i-1)/2];
			i=(i-1)/2;
		}
		this.arr[i]=data;
	}
	
	public void destryHeap(){
		this.count=0;
		this.arr=null;
	}
	
	public void buildHeap(MaxBinaryHeap h, int[] A){
		if(h==null || A.length>h.capacity)
			return;
		for(int i=0; i<A.length; i++)
			h.arr[i]=A[i];
		h.count=A.length;
		for(int j=(A.length-1)/2; j>=0; j--){
			h.percolateDown(j);
		}
	}
	
	public int[] heapsort(int[] A, int n){
		MaxBinaryHeap h=new MaxBinaryHeap(0, n);
		int old_size, temp;
		buildHeap(h, A);
		old_size=h.count;
		for(int i=0; i<h.count; i++){
			temp=h.arr[i];
			h.arr[i]=h.arr[h.count-1];
			h.arr[h.count-1]=temp;
			h.count--;
			h.percolateDown(i);
		}
		h.count=old_size;
		return h.arr;
	}
}
