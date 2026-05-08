class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ll = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean [] taken = new boolean[nums.length];
        Solve(nums,0,ans,ll,taken);
        return ans;

    }
    public static void Solve(int [] nums,int idx ,List<List<Integer>> ans,List<Integer> ll, boolean[]taken){
        if(ll.size()==nums.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && taken[i-1]==true) continue;
            if(!taken[i]){
                taken[i] = true;
                ll.add(nums[i]);
                Solve(nums,idx,ans,ll,taken);
                ll.remove(ll.size()-1);
                taken[i]=false;
            }
        }
        
    }
}