class Solution {
    public void rotate(int[][] matrix) {
        int m= matrix[0].length;
        // Step 1 Transpose
        for(int i=0;i<matrix.length;i++){
            for(int j=i;j<matrix[0].length;j++){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]= temp;
            }
        }
        // step 2 reverse each row
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length/2;j++){
                int temp = matrix[i][j];
                matrix[i][j]= matrix[i][m-j-1];
                matrix[i][m-j-1]= temp;
            }
        }
    }
}