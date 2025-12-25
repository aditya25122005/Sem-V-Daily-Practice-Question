class Solution {
    public int countNicePairs(int[] nums) {
        int mod=1000000007;
        HashMap<Integer,Integer> seen= new HashMap<>();

        long count=0;
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]-rev(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            if(seen.containsKey(nums[i])){
                count+= seen.get(nums[i]);
                int prev=seen.get(nums[i]);
                seen.put(nums[i],prev+1);
            }
            else{
                seen.put(nums[i],1);
            }
        }
        return (int)(count%mod);
        
    }
    public static int rev(int n){
        int r=0;
        while(n!=0){
            int rem=n%10;
            r= r*10 + rem;
            n/=10;

        }
        return r;
    }
}