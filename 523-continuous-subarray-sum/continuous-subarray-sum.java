class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        // 0, -1
        // 2, 0
        //
        if(nums.length<2) return false;
        map.put(0,-1);
        int curr = 0;
        for(int i=0;i<nums.length;i++){
            curr = (curr + nums[i])%k;
            if(map.containsKey(curr)){
                if(i-map.get(curr)>=2 ){
                    return true;
                }
            }
            else{
                map.put(curr,i);
            }
        }
        return false;
    }
}