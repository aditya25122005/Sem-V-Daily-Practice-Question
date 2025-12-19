class Solution {
    public void rotate(int[] nums, int k) {
        // 7654321 step 1 Rotate complete array
        // 5671234 step 2 rotate first k elements and last n-k elements separately
        k=k%nums.length;
        Rotate(nums,0,nums.length-1);
        if(k>=1)
        Rotate(nums,0,k-1);
        Rotate(nums,k,nums.length-1);

    }
    public static void Rotate(int []nums, int i, int j){
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}