package randomProblems;

/*There are n stairs, a person standing at the bottom wants to reach the top.
The person can climb either 1 stair or 2 stairs at a time. Count the number of ways, 
the person can reach the top.*/

public class WaysToReachStair {
	
	static int func(int f, int s){
		int[] res=new int[f+1];
		res[0]=1; res[1]=1;
		for(int i=2; i<f+1; i++){
			for(int j=1; j<=i && j<=s; j++){
				res[i]+=res[i-j];
			}
		}
		return res[f];
	}
	
	public static void main(String[] args) {
		int f=5; int s=3;
		int countWays=func(f,s);
		System.out.println(countWays);
	}

}
