class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) return false;
        return isValid(0,0,0,grid);
    }
    public static boolean isValid(int cr, int cc, int target, int[][] grid){
        int n=grid.length;
        if(target==n*n -1){
            return true;
        }
        int [] x={-2,-2,-1,1,2,2,1,-1};
        int [] y={-1,1,2,2,1,-1,-2,-2};
        for(int i=0;i<x.length;i++){
            int nr=cr+x[i];
            int nc=cc+y[i];
            if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==target+1){
                return isValid(nr,nc,target+1,grid);
            }
        }
        return false;
    }
}