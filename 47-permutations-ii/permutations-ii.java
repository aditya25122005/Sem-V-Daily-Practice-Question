class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        boolean [] taken = new boolean[nums.length];
        Arrays.sort(nums);
        Solve(nums,ans,ll,taken);
        return ans;


    }
    public static void Solve(int[] nums,List<List<Integer>> ans,List<Integer> ll,boolean [] taken){
        if(ll.size()==nums.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1] && taken[i-1]==false) continue; // pick in order
            if(!taken[i]){
                taken[i]= true;
                ll.add(nums[i]);
                Solve(nums,ans,ll,taken);

                taken[i]=false;
                ll.remove(ll.size()-1);
            }
        }
    }
}