package randomProblems;

/*Given an array of integers where each element represents the max number of steps 
that can be made forward from that element. Write a function to return the minimum 
number of jumps to reach the end of the array (starting from the first element). 
If an element is 0, then cannot move through that element.*/

public class MinimumJumps {
	
	 int func(int[] arr, int n){
		int[] jumps = new int[n];
		jumps[0]=0; 
		int i,j=0;
		if(arr[0]==0 || n==0)
			return Integer.MAX_VALUE;
		for(i=1; i<n;i++){
			jumps[i]=Integer.MAX_VALUE;
			for(j=0; j<i;j++){
				if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE)
					jumps[i]=Math.min(jumps[i], jumps[j]+1);
			}
		}
		return jumps[n-1];
	}

	public static void main(String[] args) {
		MinimumJumps minj=new MinimumJumps();
		int[] arr=new int[]{1, 3, 6, 1, 0, 9};
		System.out.println(minj.func(arr, arr.length));

	}

}
