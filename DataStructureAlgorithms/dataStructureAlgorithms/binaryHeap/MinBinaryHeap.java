package binaryHeap;

public class MinBinaryHeap {
	int capacity;
	int count;
	int[] arr;
	int heap_type;
	
	public MinBinaryHeap(int capacity, int heap_type){
		this.capacity=capacity;
		this.count=0;
		this.arr=new int[capacity];
		this.heap_type=heap_type;
	}
	
	int leftChild(int i){
		int left=(2*i)+1;
		if(left>=this.count)
			return -1;
		return left;
	}
	
	int rightChild(int i){
		int right=(2*i)+2;
		if(right>=this.count)
			return -1;
		return right;
	}
	
	int parent(int i){
		if(i<0 || i>=this.count)
			return -1;
		return (i-1)/2;
	}
	
	int getMinimum(){
		if(this.count==0)
			return -1;
		return this.arr[0];
	}
	
	void percolateUp(int i){
		int l, r, min, temp;
		l=leftChild(i);
		if(l!=-1 && this.arr[l]<this.arr[i])
			min=l;
		else
			min=i;
		r=rightChild(i);
		if(r!=-1 && this.arr[r]<this.arr[min])
			min=r;
		if(min!=i){
			temp=this.arr[i];
			this.arr[i]=this.arr[min];
			this.arr[min]=temp;
			percolateUp(min);
		}
	}
	
	int deleteMin(){
		if(this.count==0)
			return -1;
		int ret=this.arr[0];
		this.arr[0]=this.arr[this.count-1];
		this.count--;
		percolateUp(0);
		return ret;
	}
	
	void insert(int data){
		if(this.count==this.capacity)
			return;
		this.count++;
		int i=this.count-1;
		while(i>=0 && data<this.arr[(i-1)/2]){
			this.arr[i]=this.arr[(i-1)/2];
			i=(i-1)/2;
		}
		this.arr[i]=data;
	}
	
	void destroyHeap(){
		this.count=0;
		this.arr=null;
	}
	
	void buildHeap(MinBinaryHeap h, int[] A){
		if(h==null || A.length>h.capacity)
			return;
		for(int i=0; i<A.length; i++)
			h.arr[i]=A[i];
		h.count=A.length;
		for(int i=(A.length-1)/2; i>=0; i--){
			h.percolateUp(i);
		}
	}
	
	int[] heapSort(int[] A, int n){
		MinBinaryHeap h=new MinBinaryHeap(1, n);
		int old_size=n;
		int temp;
		for(int i=0; i<A.length; i++){
			temp=h.arr[i];
			h.arr[i]=h.arr[h.count-1];
			h.arr[h.count-1]=temp;
			h.count--;
			h.percolateUp(i);
		}
		h.count=old_size;
		return h.arr;
	}
	
}
