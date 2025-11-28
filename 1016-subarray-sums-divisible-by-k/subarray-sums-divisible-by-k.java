class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int sum=0;
        int rem=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            rem=sum%k;
            if(rem<0){
                    rem+=k;
            }
            if(!map.containsKey(rem)){
                map.put(rem,1);
            }
            else{
                // map me pehle se hai
                int prev=map.get(rem);
                ans+= prev;
                map.put(rem,prev+1);
            }
        }
        return ans;
    }
}