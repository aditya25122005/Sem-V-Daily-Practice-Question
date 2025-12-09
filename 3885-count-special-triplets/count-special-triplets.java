class Solution {
    public int specialTriplets(int[] nums) {
        int mod= 1000000007;
        HashMap<Integer,Integer> right= new HashMap<>();
        HashMap<Integer,Integer> left= new HashMap<>();
        for(int num:nums){
            right.put(num,right.getOrDefault(num,0)+1);
        }
        int ans=0;
        for(int num:nums){
            right.put(num,right.get(num)-1);
            long add = (1L* right.getOrDefault(2*num,0) * left.getOrDefault(2*num,0))%mod;
            ans= (int)((ans+add)%mod)%mod;
            left.put(num,left.getOrDefault(num,0)+1);
        }
        return ans%mod;

    }
}