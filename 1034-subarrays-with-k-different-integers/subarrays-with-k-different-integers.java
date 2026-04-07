class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return Solve(nums,k)- Solve(nums,k-1);
    }
    public static int Solve(int [] nums, int k){
        int si=0;
        int ei=0;
        HashMap<Integer,Integer>map = new HashMap<>();
        int count = 0;
        while(ei<nums.length){
            // grow
            map.put(nums[ei],map.getOrDefault(nums[ei],0)+1);

            // Shrink
            while(map.size()>k){
                int ele = nums[si];
                map.put(nums[si],map.get(nums[si])-1);
                if(map.get(nums[si])==0) map.remove(nums[si]);
                si++;
            }
            //update
            count = count+ ei-si+1;
            ei++;
        }
        return count;
    }
}