class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long total=0;
        int negCount=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int val= matrix[i][j];
                if(val<0){
                    negCount++;
                    val=-val;
                }
                total+= val;
                if(val<min){
                    min=val;
                }
                
            }
        }
        if(negCount%2==0){
            return total;
        }
        return total-min*2;
    }
}