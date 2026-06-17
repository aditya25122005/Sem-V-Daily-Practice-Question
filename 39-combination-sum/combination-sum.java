class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Solve(candidates,0,target,res,ll);
        return res;


    }
    public static void Solve(int [] candidates, int idx, int target, List<List<Integer>> res,List<Integer> ll){
        if(target==0){
            res.add(new ArrayList<>(ll));
            return;
        }
        if(idx==candidates.length){
            return;
        }
        if(candidates[idx]<=target){
            ll.add(candidates[idx]);
            Solve(candidates,idx,target-candidates[idx],res,ll);
            ll.remove(ll.size()-1);
        }
        while(idx>0 && candidates[idx]==candidates[idx-1]) idx++;
        Solve(candidates,idx+1,target,res,ll);
    }
}