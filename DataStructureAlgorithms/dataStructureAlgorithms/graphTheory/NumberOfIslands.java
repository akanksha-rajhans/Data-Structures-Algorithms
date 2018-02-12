package graphTheory;

public class NumberOfIslands {
	
	void DFS(int[][] M, int r, int c, boolean[][] visited){
		if(r<0 || c<0 || r>=5 || c>=5 || M[r][c]==0 || visited[r][c]==true) 
			return;
		
		visited[r][c]=true;
		
		for(int i=r-1; i<=r+1;i++){
			for(int j=c-1; j<=c+1; j++){
				DFS(M,i,j,visited);
			}
		}
	}
	
	int countIslands(int[][] M){
		boolean[][] visited=new boolean[5][5];
		int count=0;
		for(int row=0; row<5; row++){
			for(int col=0; col<5; col++){
				if(M[row][col]==1 && !visited[row][col]){
					DFS(M, row, col, visited);
					count++;
				}				
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int M[][]=  new int[][] {{1, 1, 0, 0, 0},
            					 {0, 1, 0, 0, 1},
            					 {1, 0, 0, 1, 1},
            					 {0, 0, 0, 0, 0},
            					 {1, 0, 1, 0, 1}
           						};
           NumberOfIslands I = new NumberOfIslands();
           System.out.println("Number of islands is: "+ I.countIslands(M));

	}

}
