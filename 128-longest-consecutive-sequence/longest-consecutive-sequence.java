class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        HashSet<Integer> hh= new HashSet<>();
        for(int num: nums){
            hh.add(num);
        }
        int ans=1;
        int curr=nums[0];
        for(int i=0;i<nums.length;i++){
            if(!hh.contains(nums[i]-1)){
                int c=1;
                int find=nums[i]+1;
                while(hh.contains(find)){
                    hh.remove(find);
                    c++;
                    find++;
                }
                ans=Math.max(ans,c);
            }
        }
        return ans;
    }
}