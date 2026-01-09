class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n= nums.length;
        int [] diff= new int[n+1];
        for(int [] Q:queries){
            int l=Q[0];
            int r=Q[1];
            diff[l]--;
            diff[r+1]++;
        }
       // [-1,-1,0,1,1]

       int curr=0;
       for(int i=0;i<nums.length;i++){
        curr+=diff[i];//-1,-2,-2,-1,-1
        if(curr+nums[i]>0) return false;
       }
       return true;

    }
}