class Solution {
    public int minOperations(int[] nums, int k) {
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%k==0) return 0;
        int c=0;
        while(sum%k!=0){
            sum--;
            c++;
        }
        return c;
    }
}