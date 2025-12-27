class Solution {
    public int minimizeArrayValue(int[] nums) {
        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }
        long curr=0;
        int res=0;
        int si=0;
        for(int i=0;i<nums.length;i++){
            curr+=nums[i];
            // if(nums[i]==max){
                int v=(int)Math.ceil((double)curr/(i+1));
                res=Math.max(res,v);
                si=i+1;

            // }

        }
        return res;
        // 6 9 3 11 11
        // 6 9 3 14 8
        // 6 9 9 8 8
        // 

        

    }
}