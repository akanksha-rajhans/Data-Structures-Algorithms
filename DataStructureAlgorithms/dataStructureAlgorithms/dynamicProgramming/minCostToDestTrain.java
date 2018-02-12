package dynamicProgramming;

//O(n) extra space and O(n2) running time

public class minCostToDestTrain {
	static int INF = Integer.MAX_VALUE,N = 4;
	
	static int minCost(int[][]cost){
		int[] dist=new int[N];
		for(int i=0; i<N; i++)
			dist[i]=INF;
		dist[0]=0;
		
		for(int a=0; a<N; a++)
			for(int b=a+1; b<N; b++){
				if(dist[b]>dist[a]+cost[a][b])
					dist[b]=dist[a]+cost[a][b];
			}
			return dist[N-1];	
	}

	public static void main(String[] args) {
		int cost[][] = { {0, 15, 80, 90},
                		 {INF, 0, 40, 50},
                		 {INF, INF, 0, 70},
                		 {INF, INF, INF, 0}
              		   };
		System.out.println("The Minimum cost to reach station "+ N + " is "+minCost(cost));

	}

}
