class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long total=0;
        int negCount=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                total+= Math.abs(matrix[i][j]);
                min=Math.min(min,Math.abs(matrix[i][j]));
                if(matrix[i][j]<0) negCount++;
            }
        }
        if(negCount%2==0){
            return total;
        }
        return total-min*2;
    }
}