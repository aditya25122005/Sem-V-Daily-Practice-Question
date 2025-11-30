class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    count=0;
                    Solve(grid,i,j);
                    ans=Math.max(ans,count);
                }
            }
        }
        return ans;
    }
    static int count;
    public static void Solve(int[][] grid, int cr, int cc){
        if(cr<0 || cr>=grid.length || cc<0 || cc>=grid[0].length || grid[cr][cc]==0){
            return;
        }
        count++;
        grid[cr][cc]=0;
        Solve(grid,cr+1,cc);
        Solve(grid,cr-1,cc);
        Solve(grid,cr,cc-1);
        Solve(grid,cr,cc+1);
    }
}