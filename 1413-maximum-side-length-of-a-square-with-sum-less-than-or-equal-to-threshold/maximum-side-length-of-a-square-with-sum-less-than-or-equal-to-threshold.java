class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        
        int n= mat.length;
        int m= mat[0].length;
        boolean [] memo= new boolean[Math.min(n,m)+1];
        int [][] pre = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int val = mat[i][j];
                if(i>0) val+= pre[i-1][j];
                if(j>0) val+= pre[i][j-1];
                if(i>0 && j>0) val-= pre[i-1][j-1];
                pre[i][j] =val;
            }
        }

        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int maxLen = Math.min(n-i,m-j);
                if(memo[maxLen]) continue;

                int lo=1;
                int hi=maxLen;
                while(lo<=hi){
                    int mid=lo+(hi-lo)/2;
                    if(isValid(pre,i,j,mid, threshold)){
                        ans=Math.max(ans,mid);
                        memo[mid]=true;
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
    public static boolean isValid(int [][] pre, int sr,int sc,int len, int limit){
        int curr=0;
        int er= sr+len-1;
        int ec= sc+len-1;
        curr= pre[er][ec];
        if(sr>0){
            curr-= pre[sr-1][ec];
        }
        if(sc>0){
            curr-= pre[er][sc-1];
        }
        if(sr>0 && sc>0){
            curr+= pre[sr-1][sc-1];
        }


        return curr<=limit;
    }
}