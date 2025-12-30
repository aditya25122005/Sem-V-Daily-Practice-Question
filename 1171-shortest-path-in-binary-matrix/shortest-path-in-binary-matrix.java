class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int []r={-1,1,0,0,-1,-1,1,1};
        int []c={0,0,-1,1,-1,1,-1,1};
        if(grid[n-1][m-1]==1 || grid[0][0]==1) return -1;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[] {0,0,1});
        while(!q.isEmpty()){
            int []A=q.poll();
            if(visited[A[0]][A[1]]) {
                continue;
            }
            visited[A[0]][A[1]] = true;

            if(A[0]==n-1 && A[1]==m-1){
                return A[2];
            }

            for(int i=0;i<8;i++){
                int nr=A[0]+r[i];
                int nc=A[1]+c[i];
                
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==0){
                    if(!visited[nr][nc]){
                    q.add(new int[]{nr,nc,A[2]+1});
                    }
                }
                
            }
        }
        return -1;

    }
}