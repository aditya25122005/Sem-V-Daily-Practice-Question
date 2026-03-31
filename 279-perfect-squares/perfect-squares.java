class Solution {
    public int numSquares(int n) {
        
        List<Integer> perSq= new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            perSq.add(i*i);
        }
        Integer [] dp= new Integer[n+1];
        return Solve(perSq,0,n,dp);

    }
    public static int Solve(List<Integer> ll, int idx,int target,Integer[] dp){
        if(idx>=ll.size()){
            return Integer.MAX_VALUE;
        }
        if(target<0){
            return Integer.MAX_VALUE;
        }
        if(target==0){
            return 0;
        }
        if(dp[target] != null) return dp[target];
        int A=Integer.MAX_VALUE;
        int B=Integer.MAX_VALUE;
        if(ll.get(idx)<= target){
            int next1=Solve(ll,idx, target-ll.get(idx),dp);
            if(next1!= Integer.MAX_VALUE){
                A= 1+ next1;
            }
        }
        B= Solve(ll,idx+1,target,dp);

        return dp[target] = Math.min(A,B);

    }
}