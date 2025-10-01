class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int [] maxies= new int[matrix[0].length];
        
        for(int j=0;j<matrix[0].length;j++){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<matrix.length;i++){
                max=Math.max(max,matrix[i][j]);
            }
            maxies[j]=max;
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=maxies[j];
                }
            }
        }
        return matrix;
    }
}