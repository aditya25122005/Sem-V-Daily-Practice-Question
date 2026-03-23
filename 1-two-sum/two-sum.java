class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans= new int[2];
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int curr= nums[i];
            int needed= target-curr;
            if(map.containsKey(needed)){
                int idx= map.get(needed);
                ans[0]=idx;
                ans[1]=i;
                return ans;
            }
            else{
                map.put(curr,i);
            }
        }
        return ans;
    }
}