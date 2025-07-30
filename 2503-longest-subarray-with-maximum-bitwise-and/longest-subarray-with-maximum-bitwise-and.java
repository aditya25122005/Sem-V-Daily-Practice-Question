class Solution {
    public int longestSubarray(int[] nums) {
        int maxnum=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>maxnum){
                maxnum=num;
            }
        }
        int curr=0;
        int maxlen=0;
        for(int num:nums){
            if(num==maxnum){
                curr++;
            }
            else{
                maxlen=Math.max(curr,maxlen);
                curr=0;
            }
        }
        return Math.max(curr,maxlen);
    }
}