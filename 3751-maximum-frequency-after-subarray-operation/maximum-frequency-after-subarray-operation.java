class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max=0;
        int ck=0;
        int [] pre = new int[51];
        // we have numbers in range 1 to 50 only
        // pre[nums[i]] -> Stores Max achievable k till this idx
        for(int i=0;i<nums.length;i++){
            if(nums[i]==k){
                ck++;
                pre[nums[i]]=max+1;
            }
            else{
                pre[nums[i]]=Math.max(pre[nums[i]],ck)+1;
                // +1 for current no. frequency
                // we take max because if , TILL Now Count of k is greater than 
                // freq of nums[i] then no point in converting nums[i] to k
            }
            max=Math.max(max, pre[nums[i]]);
        }
        return max;
    }
}