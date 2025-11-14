class Solution {
    public void nextPermutation(int[] nums) {
        int n= nums.length;
        int i=n-2;
        while(i>=0 &&nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){

            int j=n-1;
            while(nums[j]<=nums[i]){
                j--;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        sort(nums,i+1,n-1);

    }
    public static void sort(int [] nums, int i, int j){
        while(i<j){
            int temp= nums[j];
            nums[j]=nums[i];
            nums[i]=temp;
            i++;
            j--;
        }
    }
}