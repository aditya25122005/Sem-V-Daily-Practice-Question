class Solution {
    public int[] sortedSquares(int[] nums) {
        int j=-1;
        
        int i2=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                i2=i;
            }
            else{
                break;
            }
        }
        j=i2+1;

        int [] ans= new int[nums.length];
        int k=0;
        while(j<nums.length  && i2>=0){
            int num1= nums[j]*nums[j];
            int num2= nums[i2]*nums[i2];
            if(num1<num2){
                ans[k++]= num1;
                j++;
            }
            else{
                ans[k++]=num2;
                i2--;
            }
        }
        while(j<nums.length){
            ans[k++]= nums[j]*nums[j];
            j++;
        }
        while(i2>=0){
            ans[k++]=nums[i2]*nums[i2];
            i2--;
        }
        return ans;
    }
}