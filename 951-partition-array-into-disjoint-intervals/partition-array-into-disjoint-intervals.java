class Solution {
    public int partitionDisjoint(int[] nums) {
        int n= nums.length;
        int [] maxis= new int[nums.length];
        maxis[0]=nums[0];
        for(int i=1;i<maxis.length;i++){
            maxis[i]=Math.max(maxis[i-1],nums[i]);
        }
        int[] rightMin= new int[nums.length];
        rightMin[n-1]= nums[n-1];
        for(int i=n-2;i>=0;i--){
            rightMin[i]=Math.min(nums[i],rightMin[i+1]);
        }
        int max=nums[0];
        int lidx=0;
        for(int i=1;i<nums.length;i++){
            if(max>rightMin[i]){
                lidx=i;
                max=maxis[lidx];
            }
        }
        return lidx+1;
        
    }
}