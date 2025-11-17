class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int idx1=-1;
        int idx2=-1;
    for(int i=0;i<nums.length;i++){
        if(nums[i]==1){
            idx1=i;
            break;
        }
    }
    for(int i=idx1+1;i<nums.length;i++){
        if(nums[i]==1){
            if(i-idx1-1<k ) return false;
             else{
            idx1=i;
               }
        }
       
    }
    return true;
    }
}