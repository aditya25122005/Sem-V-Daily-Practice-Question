class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        HashSet<Integer> hh = new HashSet<>();
        int si=0;
        int ei=0;
        long ans=0;
        long curr=0;
        while(ei<nums.length){
            if(!hh.contains(nums[ei]) && hh.size()<k){
                hh.add(nums[ei]);
                curr+= nums[ei];
                if(hh.size()==k){
                    ans=Math.max(ans,curr);
                }

            }
            else{
                while(hh.contains(nums[ei])){
                    hh.remove(nums[si]);
                    curr-= nums[si];
                    si++;
                }
                hh.add(nums[ei]);
                curr+= nums[ei];
                if(hh.size()==k){
                    ans=Math.max(ans,curr);
                }
            }

            while(hh.size()>=k){
                hh.remove(nums[si]);
                curr-= nums[si];
                si++;
            }
            ei++;
        }
        return ans;
    }
}