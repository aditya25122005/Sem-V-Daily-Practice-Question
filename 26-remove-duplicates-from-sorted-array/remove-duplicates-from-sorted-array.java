class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> hh = new HashSet<>();

        int j=0;
        for(int i=0;i<nums.length;i++){
            if(!hh.contains(nums[i])){
                hh.add(nums[i]);
                nums[j++]= nums[i];
                
            }
            else{
                
            }
        }
        return j;
    }
}