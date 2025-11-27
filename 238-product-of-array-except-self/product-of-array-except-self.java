class Solution {
    public int[] productExceptSelf(int[] nums) {
        // 1 1 2 6
        // 24  12  4  1
        int n= nums.length;

        int [] pre= new int[n];
        int [] suf= new int[n];
        pre[0]=1;
        for(int i=1;i<n;i++){
            pre[i]=pre[i-1]*nums[i-1];
        }
        suf[n-1] =1;
        for(int i=n-2;i>=0;i--){
            suf[i]=suf[i+1]*nums[i+1];
        }
        int i=0;
        int j=n-1;
        int[] ans= new int[n];
        int idx=0;

        while(i<n){
            ans[idx++]= pre[i]*suf[i];
            i++;
         
        }
        return ans;
    }
}