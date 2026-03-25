class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        boolean [] isTaken = new boolean[nums.length];
        Solve(nums,isTaken,ll,ans);
        return ans;

    }
    public static void Solve(int [] nums,boolean [] isTaken,List<Integer> ll,List<List<Integer>> ans){
        if(ll.size()==nums.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!isTaken[i]){
                ll.add(nums[i]);
                isTaken[i]=true;
                Solve(nums,isTaken,ll,ans);
                ll.remove(ll.size()-1);
                isTaken[i]=false;
            }
            //Solve(nums,i+1,isTaken,ll,ans);
        }
    }
}