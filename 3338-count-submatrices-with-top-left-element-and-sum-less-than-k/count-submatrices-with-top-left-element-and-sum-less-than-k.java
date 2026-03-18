class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n= grid.length;
        int m= grid[0].length;
        int [][] A= new int[n][m];
        for(int i=0;i<n;i++){
            int curr=0;
            for(int j=0;j<m;j++){
                curr+= grid[i][j];
                A[i][j]=curr;
            }
        }
        int c=0;
        for(int j=0;j<m;j++){
            int curr=0;
            for(int i=0;i<n;i++){
                curr+= A[i][j];
                if(curr<=k) c++;
            }
        }
        return c;
    }
}