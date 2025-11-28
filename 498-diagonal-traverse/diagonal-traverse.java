class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        int idx=0;
        int row=0;
        int col=0;
        int dir=1;
        
        int[] ans= new int[m*n];
        while(idx < m*n){
            ans[idx++]=mat[row][col];
            if(dir==1){
                if(col==n-1){
                    dir=0;
                    row++;
                }
                else if(row==0){
                    dir=0;
                    col++;
                }
                else{
                    row--;
                    col++;
                }
            }
            else{
                
                if(row==m-1){
                    dir=1;
                    col++;
                }
                else if(col==0){
                    dir=1;
                    row++;
                }
                else{
                    row++;
                    col--;
                }
            }
        
        }
        return ans;
        
    }
}