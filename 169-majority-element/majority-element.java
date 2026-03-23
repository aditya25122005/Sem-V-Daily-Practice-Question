class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int winner = nums[0];
        int vote=1;

        for(int i=1;i<nums.length;i++){
            if(nums[i]==winner){
                vote++;
                if(vote> n/2){
                    return winner;
                }
            }
            else{
                winner=nums[i];
                vote=1;
            }
        }
        return winner;
    }
}