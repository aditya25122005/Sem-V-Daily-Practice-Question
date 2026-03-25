class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long total=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                total+= grid[i][j];
            }
        }
        if(total%2==1) return false;
        long curr=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                curr+= grid[i][j];
                if(j==grid[0].length-1 && curr== total/2){
                    return true;
                }
            }
        }
        curr=0;
        for(int i=0;i<grid[0].length;i++){
            for(int j=0;j<grid.length;j++){
                curr+= grid[j][i];
                if(j==grid.length-1 && curr==total/2){
                    return true;
                }
            }
        }
        return false;
    }
}