class Solution {
    public int longestBalanced(int[] nums) {
        int ans= Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            HashSet<Integer> odd= new HashSet<>();
            HashSet<Integer> even= new HashSet<>();
            for(int j=i;j<nums.length;j++){
                if(nums[j]%2==0){
                    even.add(nums[j]);
                }
                else{
                    odd.add(nums[j]);
                }
                if(odd.size()==even.size()) ans=Math.max(ans,j-i+1);
            }
        }
        return ans==Integer.MIN_VALUE? 0: ans;
    }
}