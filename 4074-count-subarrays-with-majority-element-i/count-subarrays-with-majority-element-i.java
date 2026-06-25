class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int j=i;j<nums.length;j++){
                map.put(nums[j], map.getOrDefault(nums[j],0)+1);
                if(map.containsKey(target) && map.get(target)>(j-i+1)/2){
                    cnt++;
                }
                //  System.out.println(map);
            }
           
            
        }
        return cnt;
    }
}