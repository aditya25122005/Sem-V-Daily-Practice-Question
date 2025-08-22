class Solution {
    public int minimumArea(int[][] grid) {
        int sr=grid.length;
        int sc=grid[0].length;
        int er=-1;
        int ec=-1;
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                   sr=Math.min(sr,i);
                   er=Math.max(er,i);
                   sc=Math.min(sc,j);
                   ec=Math.max(ec,j);
                }
            }
        }
        return (er-sr+1)*(ec-sc+1);
    }
}