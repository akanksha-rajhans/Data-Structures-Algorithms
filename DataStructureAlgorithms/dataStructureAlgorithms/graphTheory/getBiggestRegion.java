package graphTheory;

public class getBiggestRegion {
	
	int getBiggestRegionUtil(int[][]M, int r, int c, boolean[][] visited){
		if(r<0 || c<0 || r>=4 || c>=5 || M[r][c]==0 || visited[r][c]==true){
			return 0;
		}
	
		int size=1;
		visited[r][c]=true;
		for(int ro=r-1; ro<=r+1; ro++)
			for(int co=c-1; co<=c+1; co++)
				if(ro!=r || co!=c)
					size+=getBiggestRegionUtil(M, ro, co, visited);
		
		return size;
	}
	
	int getBiggestRegionFunc(int[][] M){
		boolean[][] visited=new boolean[4][5];
		int maxSize=0;
		
		for(int row=0; row<4; row++){
			for(int col=0; col<5; col++){
				if(M[row][col]==1 && !visited[row][col]){
					int size=getBiggestRegionUtil(M,row,col, visited);
					maxSize=Math.max(size, maxSize);
				}
			}
		}
		return maxSize;
	}

	public static void main(String[] args) {
		int M[][]=  new int[][] {{0, 0, 1, 1, 0},
            					{1, 0, 1, 1, 0},
            					{0, 1, 0, 0, 0},
            					{0, 0, 0, 0, 1}
								};
		getBiggestRegion br = new getBiggestRegion();
		System.out.println("Size of Bigest Region is: "+ br.getBiggestRegionFunc(M));
	}

}
