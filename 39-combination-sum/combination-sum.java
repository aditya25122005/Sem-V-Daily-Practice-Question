class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        Arrays.sort(candidates);
        Solve(candidates,0,0,target, ans,ll);
        return ans;
    }
    public static void Solve(int [] coins, int idx, int curr, int target,List<List<Integer>> ans,
    List<Integer> ll){
        if(idx==coins.length){
            if(curr==target){
                ans.add(new ArrayList<>(ll));
                return;
            }
            return;
        }
        if(curr==target){
            ans.add(new ArrayList<>(ll));
            return;
        }

        if(target-curr >= coins[idx]){
            ll.add(coins[idx]);
            Solve(coins,idx,curr+coins[idx],target,ans,ll);
            ll.remove(ll.size()-1);
        }
        while(idx<coins.length-1 && coins[idx]==coins[idx+1]){
            idx++;
        }
        Solve(coins,idx+1,curr,target,ans,ll);
    }
}