class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j] && map.get(nums[i])!= map.get(nums[j])){
                    return new int[]{nums[i],nums[j]};
                }
            }
        }
        return new int[]{-1,-1};
    }
}