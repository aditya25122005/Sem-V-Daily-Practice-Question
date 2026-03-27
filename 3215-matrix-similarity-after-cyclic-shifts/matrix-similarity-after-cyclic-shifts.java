class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        // Odd row-> START WITH col= N-k
        // Even row Start With col= k
        int n= mat.length;
        int m= mat[0].length;
        k=k%m;
        int idx=0;
        for(int i=0;i<mat.length;i++){
            idx=0;
            if(i%2==0){
                for(int j=k;j<mat[0].length+k;j++){
                    if(mat[i][j%mat[0].length]!= mat[i][idx]) return false;
                    idx++;
                }
            }
            else{
                for(int j=m-k;j<m-k+m;j++){
                    if(mat[i][j%mat[0].length]!= mat[i][idx]) return false;
                    idx++;
                }
            }
            
        }
        return true;
    }
}