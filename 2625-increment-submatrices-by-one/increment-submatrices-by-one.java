class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans= new int[n][n];
        for(int[] Q:queries){
            int sr=Q[0];
            int sc=Q[1];
            int er=Q[2];
            int ec=Q[3];
            for(int i=sr;i<=er;i++){
                for(int j=sc;j<=ec;j++){
                    ans[i][j]++;
                }
            }
        }
        return ans;
    }
}