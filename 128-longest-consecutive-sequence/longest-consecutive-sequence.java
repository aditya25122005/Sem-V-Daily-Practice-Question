class Solution {
    public int longestConsecutive(int[] nums) {
      
        int ans=0;

        HashSet<Integer> hh= new HashSet<>();
        for(int num:nums){
            hh.add(num);
        }
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
           
            if(!hh.contains(nums[i]-1)){
                int c=1;
                int key=nums[i]+1;
                while(hh.contains(key)){
                    hh.remove(key);
                    c++;
                    key++;
                }
                ans=Math.max(ans,c);
            }
            

        }
        return ans;
    }
}