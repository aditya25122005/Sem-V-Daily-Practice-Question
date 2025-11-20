class Solution {
    public int minimumArea(int[][] grid) {
        int firstRow=Integer.MAX_VALUE, lastRow=Integer.MIN_VALUE;
        int firstCol=Integer.MAX_VALUE, lastCol=Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    firstRow=Math.min(firstRow, i);
                    firstCol=Math.min(firstCol, j);
                    lastRow=Math.max(lastRow, i);
                    lastCol=Math.max(lastCol, j);
                }
            }
        }
        return (lastRow-firstRow+1)*(lastCol-firstCol+1);
    }
}