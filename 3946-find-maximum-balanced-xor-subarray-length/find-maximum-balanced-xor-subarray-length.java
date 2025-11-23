class Solution {
    public int maxBalancedSubarray(int[] nums) {
        HashMap<String,Integer> map= new HashMap<>();
        map.put("0#0",-1);
        int even=0;
        int odd=0;
        int Xor=0;
        int maxLen=0;
        for(int i=0;i<nums.length;i++){
            Xor ^= nums[i];
            if(nums[i]%2==0) even++;
            else odd++;
            String s= Xor +"#" + (even-odd);
            if(map.containsKey(s)){
                maxLen=Math.max(maxLen,i-map.get(s));
            }
            else{
                map.put(s,i);
            }
        }
        return maxLen;
    }
}