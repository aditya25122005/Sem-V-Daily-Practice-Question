class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Solve(candidates,0,target,res,ll);
        return res;
    }
    public static void Solve(int [] candidates, int idx, int target, List<List<Integer>> res, List<Integer> ll){
        if(target==0){
            System.out.println(ll);
            res.add(new ArrayList<>(ll));
            return;
        }
        if(idx==candidates.length){
            return;
        }

        if(candidates[idx]<=target){
            
            ll.add(candidates[idx]);
            Solve(candidates,idx+1,target-candidates[idx], res, ll);
            ll.remove(ll.size()-1);
        }
        while(idx+1<candidates.length && candidates[idx]==candidates[idx+1]) idx++;
        Solve(candidates,idx+1,target,res,ll);
        
        // Solve(candidates,idx+1,target,res,ll);
    }

}