class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int odd=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        // map.put(0,0);

        // 0,0,0,1,1,1,2,2,2,2

        //0->3

        int count=0;
        int curr=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                curr++;
            }
            if(map.containsKey(curr-k)){
                count+= map.get(curr-k);
            }
            map.put(curr,map.getOrDefault(curr,0)+1);
        }
        return count;
    }
}