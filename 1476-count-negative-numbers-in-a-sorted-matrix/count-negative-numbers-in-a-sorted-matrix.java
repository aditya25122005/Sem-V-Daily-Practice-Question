class Solution {
    public int countNegatives(int[][] grid) {
        int cr=0;
        int cc=grid[0].length-1;
        int count=0;
        while(cr<grid.length && cc>=0){
            if(grid[cr][cc]<0){
                count+= grid.length-cr;
                cc--;
            }
            else{
                cr++;
            }
        }
        return count;
    }
}