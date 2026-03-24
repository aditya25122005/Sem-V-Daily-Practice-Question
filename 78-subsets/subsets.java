class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        Solve(nums,0,ans,ll);
        return ans;
    }
    public static void Solve(int [] nums, int idx, List<List<Integer>> ans, List<Integer> ll){
        if(idx==nums.length){
            ans.add(new ArrayList<>(ll));
            return;
        }

        ll.add(nums[idx]);
        Solve(nums,idx+1,ans,ll);
        ll.remove(ll.size()-1);

        Solve(nums,idx+1,ans,ll);
    }   
}