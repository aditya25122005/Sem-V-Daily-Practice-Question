class Solution {
    public int centeredSubarrays(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int curr=0;
            HashSet<Integer> hh= new HashSet();
            for(int j=i;j<nums.length;j++){
                hh.add(nums[j]);
                curr+= nums[j];
                if(hh.contains(curr)) count++;
            }
        }
        return count;
    }
}