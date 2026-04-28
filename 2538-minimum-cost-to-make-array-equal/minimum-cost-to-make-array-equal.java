class Solution {
    public long minCost(int[] nums, int[] cost) {
        int lo = Integer.MAX_VALUE;
        int hi= Integer.MIN_VALUE;
        for(int num : nums){
            lo = Math.min(lo,num);
            hi = Math.max(hi,num);
        }
        long ans= Long.MAX_VALUE;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            // make every element equal to mid
            long res = Solve(mid,nums,cost);
            ans= Math.min(ans,res);
            long left = Solve(mid-1,nums,cost);
            long right = Solve(mid+1,nums,cost);
            if(left<right){
                hi=mid-1;
            }
            else if(right<left){
                lo=mid+1;
            }
            else{
                return ans;
            }
        }
        return ans;
    }
    public static long Solve(int target, int [] nums, int [] cost){
        long total = 0;
        for(int i=0;i<cost.length;i++){
            total+= Math.abs(target-nums[i])*(long)cost[i];
        }
        return total;
    }
}