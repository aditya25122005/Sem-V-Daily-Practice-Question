class Solution {
    public int minimumNumbers(int num, int k) {
        if(num==0){
            return 0;
        }
        List<Integer> ll= new ArrayList<>();
        for(int i=k;i<=num;i++){
            if(i%10==k){
                ll.add(i);
            }
        }
        if(k==0){
            ll.remove(0);
        }
        int [][] dp= new int[ll.size()][num+1];
        for(int [] A:dp) Arrays.fill(A,-1);
        int ans=Solve(ll,0,num,0,dp);
        return ans==Integer.MAX_VALUE? -1 :ans;

    }
    public static int Solve(List<Integer> ll, int idx, int target, int currSum, int [][] dp){
        if(currSum==target){
            return 0;
        }
        if(currSum>target){
            return Integer.MAX_VALUE;
        }
        if(idx==ll.size()){
            return Integer.MAX_VALUE;
        }
        if(dp[idx][currSum]!=-1) return dp[idx][currSum];
        int A= Solve(ll,idx+1,target,currSum,dp);
        int B=0;
        B=Solve(ll,idx,target,currSum+ll.get(idx),dp);
        if(B!=Integer.MAX_VALUE){
            B+=1;
        }
        return dp[idx][currSum] = Math.min(A,B);
    }
}