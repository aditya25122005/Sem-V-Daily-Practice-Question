class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int curr=0;

        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            curr = (curr+ nums[i])%k;

            if(map.containsKey(curr) && i-map.get(curr)>=2){
                return true;
            }
            if(!map.containsKey(curr)){
                map.put(curr,i);
            }
        }
        return false;
    }
}