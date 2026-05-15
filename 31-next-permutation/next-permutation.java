class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i=nums.length-2;
        while(i>=0){
            if(nums[i]<nums[i+1]){
                break;
            }
            i--;
        }
        if(i>=0){
            for(int j=n-1;j>i;j--){
                if(nums[j]>nums[i]){
                    int temp = nums[j];
                    nums[j]= nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
        reverse(nums,i+1,nums.length-1);
    }
    public static void reverse(int [] arr, int i, int j){
        while(i<j){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
}