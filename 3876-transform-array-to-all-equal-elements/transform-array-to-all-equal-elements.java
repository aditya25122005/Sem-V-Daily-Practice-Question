class Solution {
    public boolean canMakeEqual(int[] nums, int k) {
        return isPossible(nums.clone(),k,1) || isPossible(nums.clone(),k,-1);
    }
    public static boolean isPossible(int [] arr, int k, int target){
        int opr=0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]!=target){
                arr[i]*=-1;
                arr[i+1]*=-1;
                opr++;
                if(opr>k){
                    return false;
                }

            }
        }
        if(arr[arr.length-1]==target && opr<=k) return true;
        return false;
    }
}