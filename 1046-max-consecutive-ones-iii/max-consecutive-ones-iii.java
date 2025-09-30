class Solution {
    public int longestOnes(int[] nums, int k) {
        // return Solve(nums,k);
        return Solve2(nums,k);
    }
    public static int Solve(int[] nums, int k){
        int si=0;
        int ei=0;
        int curr=0;
        int ans=0;
        int used=0;
        while(ei<nums.length){
            if(nums[ei]==1){
                curr++;
            }else if(nums[ei]==0){
                if(used<k){
                    curr++;
                    used++;
                }

                else{
                while(used==k){
                    if(nums[si]==0){
                        used--;
                    }
                    si++;
                    curr--; 
                }
                curr++;
                used++;
            } 
            }
            ans=Math.max(ans,curr);
            ei++;
       }
       return ans;
    }
    public static int Solve2(int[] nums, int k){// maintain zero count 
        int zero=0;
        int si=0;
        int ei=0;
        int ans=0;
        while(ei<nums.length){
            if(nums[ei]==0){
                zero++;
            }
            while(zero>k){
                if(nums[si]==0){
                    zero--;
                }
                si++;
            }
            
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;

    }
}