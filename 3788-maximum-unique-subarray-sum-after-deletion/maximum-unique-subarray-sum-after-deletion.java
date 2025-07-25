class Solution {
    public int maxSum(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                max=num;
            }
        }
        if(max<0){
            return max;
        }
        HashSet<Integer>hh= new HashSet<>();
        for(int num:nums){
            if(num>0) hh.add(num);
        }
        int ans=0;
        for(int num:hh){
            ans+=num;
        }
        return ans;
    }
}