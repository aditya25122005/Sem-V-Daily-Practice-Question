class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen=0;
        Arrays.sort(nums);
        HashSet<Integer> hh= new HashSet<>();
        for(int num: nums){
            hh.add(num);
        }

        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            hh.add(val);
            int key= val+1;
            int len=1;
            while(hh.contains(key)){
                hh.remove(key);
                key++;
                len++;
            }
            maxLen=Math.max(maxLen, len);
        }
        return maxLen;
    }
}