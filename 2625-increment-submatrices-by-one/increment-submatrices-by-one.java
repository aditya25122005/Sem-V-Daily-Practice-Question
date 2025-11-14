class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] ans= new int[n][n];
        for(int[] Q:queries){
            int sr=Q[0];
            int sc=Q[1];
            int er=Q[2];
            int ec=Q[3];
            for(int i=sr;i<=er;i++){
                ans[i][sc]+=1;
                if(ec+1<n){
                    ans[i][ec+1]-=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            int pre=0;
            for(int j=0;j<n;j++){
                pre+=ans[i][j];
                ans[i][j]= pre;
            }
        }
        return ans;
    }
}