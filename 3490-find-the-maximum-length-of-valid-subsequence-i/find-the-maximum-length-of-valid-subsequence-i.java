class Solution {
    public int maximumLength(int[] nums) {
     int odd=0;
     int even=0;
     int alternate=0;
     int prev=nums[0]%2;
     for(int num:nums){
        if(num%2==0) even++;
        else odd++;
        if(num%2==prev){
            alternate++;
            prev=1-prev;
        }


     }
     return Math.max(alternate,Math.max(even,odd));   
    }
}