class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        for(int i=0;i<nums.length;i++){
            nums[i]=((nums[i]%value)+value)%value;
        }
        int [] freq= new int[value];

        for(int num:nums){
            freq[num]++;
        }
        int ans=0;
        while(true){
            int mod= ans % value;
            if(freq[mod]==0) return ans;

            freq[mod]--;
            ans++;
        }
        
    }
}
// 1 , 6, 6, 0,3,1