class Solution {
    public int findMaxLength(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0){
                nums[i]=-1;
            }
        }
        HashMap<Integer,Integer> map= new HashMap<>(); // sum, idx
        map.put(0,-1);
        int ans=0;
        int curr=0;
        for(int i=0;i<nums.length;i++){
            curr+= nums[i];
            if(map.containsKey(curr)){
                ans=Math.max(ans, i-map.get(curr));
            }
            else{
                map.put(curr , i);
            }
        }
        return ans;
    }

}