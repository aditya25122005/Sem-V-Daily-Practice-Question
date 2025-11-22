class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        int [] ans= new int[n];
        long sum=0;
        for(int i=1;i<=n;i++){
            ans[i-1]=i;
            sum+=i;
        }
        if(target<-sum || target>sum ){
            return new int[]{};
        }
        int i=n-1;
        while(i>=0 && sum>target){ // 3-> -3 --> -2*3
            long dec=(long)(ans[i]*2);
            if(sum-dec>=target){
                sum-=dec;
                ans[i]=-ans[i];
               
            }
             i--;
        }
        Arrays.sort(ans);
        if(sum==target){
            return ans;
        }
        return new int[]{};
    }
}