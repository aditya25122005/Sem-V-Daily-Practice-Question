class Solution {
    public int countElements(int[] nums) {
        int n= nums.length;
        Arrays.sort(nums);
        int l=0;
        while(l<n-1){
            if(nums[l]==nums[l+1]){
                l++;
            }
            else{
                break;
            }
        }
        int r=n-1;
        while(r>0){
            if(nums[r]==nums[r-1]){
                r--;
            }
            else{
                break;
            }
            
        }
        if(r<=l) return 0;
        return r-l-1;


    }
}