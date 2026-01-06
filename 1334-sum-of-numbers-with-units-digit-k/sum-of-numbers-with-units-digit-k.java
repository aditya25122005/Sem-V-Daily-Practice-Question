class Solution {
    // 1, 11, 21, 31,--
    int k;
    public int minimumNumbers(int num, int k) {
        if(num==0) return 0;
        List<Integer> ll= new ArrayList<>();
        
        for(int n=k;n<=num;n++){
            if(n%10==k){
                
                ll.add(n);
            }
        }
        if(k==0){
            ll.remove(0);
        }
        this.k=k;
        int [][] dp= new int[num+1][ll.size()+1];

            for(int []A:dp){
                Arrays.fill(A,-1);
            }
        
        int ans=Solve(0,num,0,ll,dp);
        return ans==Integer.MAX_VALUE? -1:ans ;

    }
    public int Solve(int currSum,int Target, int idx, List<Integer> ll, int[][]dp){
        if(currSum==Target){
            return 0;
        }
        if(currSum>Target){
            return Integer.MAX_VALUE;
        }
        if(idx==ll.size()){
            return Integer.MAX_VALUE;
        }
        if(dp[currSum][idx]!=-1) return dp[currSum][idx];
        // skip
        int a= Solve(currSum,Target,idx+1,ll,dp);
        int b=0;
        //take this 
            b=Solve(currSum+ll.get(idx),Target,idx,ll,dp);
            if(b!=Integer.MAX_VALUE){
                b+=1;
            }
        return dp[currSum][idx] = Math.min(a,b);
    }
}