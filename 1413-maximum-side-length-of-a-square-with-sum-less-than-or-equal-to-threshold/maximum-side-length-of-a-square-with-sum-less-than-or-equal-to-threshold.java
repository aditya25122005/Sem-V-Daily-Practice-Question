class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int n= mat.length;
        int m= mat[0].length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int maxLen = Math.min(n-i,m-j);
                int lo=1;
                int hi=maxLen;
                while(lo<=hi){
                    int mid=lo+(hi-lo)/2;
                    if(isValid(mat,i,j,mid, threshold)){
                        ans=Math.max(ans,mid);
                        lo=mid+1;
                    }
                    else{
                        hi=mid-1;
                    }
                }
            }
        }
        return ans;
    }
    public static boolean isValid(int [][] mat, int sr,int sc,int len, int limit){
        int curr=0;
        for(int i=sr;i<sr+len;i++){
            for(int j=sc;j<sc+len;j++){
                curr+= mat[i][j];
                if(curr>limit) return false;
            }
        }
        return curr<=limit;
    }
}