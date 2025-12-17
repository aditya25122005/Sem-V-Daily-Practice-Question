class Solution {
    public void sortColors(int[] nums) {
        int c=0;
        int z=0;
        int t=nums.length-1;
        while(c<=t){
            if(nums[c]==0){
                swap(nums,z,c);
                z++;
                c++;
            }
            else if(nums[c]==1){
                c++;
            }
            else{
                swap(nums,c,t);
                t--;
            }
        }
    }
    public static void swap(int[]arr, int i, int j){
        int temp=arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}