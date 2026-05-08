class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        Solve(nums,ans,ll,taken);
        return ans;


    }
    public static void Solve(int [] nums, List<List<Integer>> ans, List<Integer> ll, boolean[]taken){
        if(ll.size()==nums.length){
            ans.add(new ArrayList<>(ll));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(!taken[i]){
                ll.add(nums[i]);
                taken[i] = true;
                Solve(nums,ans,ll,taken);
                ll.remove(ll.size()-1);
                taken[i]=false;
            }
        }
    }
}