class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(nums);
        Solve(nums,ans);
        return ans;

    }
    public static void Solve(int[] nums, List<List<Integer>> ans){
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
            int curr=nums[i]+nums[left]+nums[right];
            if(curr==0){
                List<Integer> ll= new ArrayList<>();
                ll.add(nums[i]);
                ll.add(nums[left]);
                ll.add(nums[right]);
                ans.add(new ArrayList<>(ll));
                left++;
                right--;
                while(left<right && nums[left]==nums[left-1]) left++;
                while(left<right && nums[right]==nums[right+1]) right--;

            }else if(curr<0){
                left++;
                while(left<right && nums[left]==nums[left-1]) left++; 
            }
            else{
                right--;
                while(left<right && nums[right]==nums[right+1]) right--;
            }


            }
        }

    }
}