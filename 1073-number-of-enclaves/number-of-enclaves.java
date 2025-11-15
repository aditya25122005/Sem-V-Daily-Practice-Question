class Solution {
    public int numEnclaves(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        // boundary rows;
        for(int i=0;i<m;i++){
            DFS(grid,0,i);
            DFS(grid,n-1,i);
        }
        // boundary cols
        for(int i=0;i<n;i++){
            DFS(grid,i,0);
            DFS(grid,i,m-1);
        }

        int cnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public static void DFS(int[][] grid, int cr, int cc){
        int n=grid.length;
        int m= grid[0].length;
        if(cr<0 || cr>=n || cc<0 || cc>=m || grid[cr][cc]==0){
            return;
        }
        grid[cr][cc]=0;
        DFS(grid,cr+1,cc);
        DFS(grid,cr,cc+1);
        DFS(grid,cr-1,cc);
        DFS(grid,cr,cc-1);

    }
}