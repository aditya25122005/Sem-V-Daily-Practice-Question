class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        // 2+1-1-2
        int n= grid.length;
        int m= grid[0].length;

        int [] row= new int[grid.length];
        int [] col= new int[grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    row[i]++;
                }
            }
        }
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                if(grid[i][j]==1){
                    col[j]++;
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j]= row[i]+col[j] - (n-row[i])- (m-col[j]);
            }
        }
        return grid;
    }
}