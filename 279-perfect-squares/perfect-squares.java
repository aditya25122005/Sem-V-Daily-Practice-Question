class Solution {
    public int numSquares(int n) {
        List<Integer> perfectSq= new ArrayList<>();
        int last=-1;
        for(int i=1;i*i<=n;i++){
            perfectSq.add(i*i);
        }
        int [][] dp= new int[perfectSq.size()][n+1];
        for(int [] A:dp) Arrays.fill(A,-1);
        return Solve(0,perfectSq,n, dp);
    }
    public static int Solve(int idx, List<Integer> ll, int n, int[][] dp){
       
        if(n==0){
            return 0;
        }
        if(idx>= ll.size()){
            return Integer.MAX_VALUE;
        }
        if(n<0){
            return 0;
        }
        if(dp[idx][n]!=-1)return dp[idx][n];
        int A=Integer.MAX_VALUE;
        int B=Integer.MAX_VALUE;
        // take this
        if(ll.get(idx)<=n){
            int next =  Solve(idx,ll,n-ll.get(idx),dp);
            if(next!=Integer.MAX_VALUE){
                A=Math.min(A,1+next);
            }
        }
        // skip this
        B = Solve(idx+1,ll,n,dp);

        return dp[idx][n] = Math.min(A,B);
    }
}