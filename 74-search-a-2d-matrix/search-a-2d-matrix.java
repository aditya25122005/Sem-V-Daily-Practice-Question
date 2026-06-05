class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        int m = matrix[0].length;
        int lo =0;
        int hi= m-1;
        while(lo<n && hi>=0){
            if(matrix[lo][hi]==target){
                return true;
            }
            else if(target<matrix[lo][hi]){
                hi--;
            }
            else if(target>matrix[lo][hi]){
                lo++;
            }
        }
        return false;

    }
}