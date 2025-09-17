class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ll= new ArrayList<>();
        List<Integer> inner= new ArrayList<>();
        Solve(candidates,target,ll,inner,0);
        return ll;
    }
    public static void Solve(int[] coins, int Target,List<List<Integer>> ll, List<Integer> inner, int idx){
        if(Target==0){
            ll.add(new ArrayList<>(inner));
            return;
        }
        if(idx==coins.length){
            return;
        }

        for(int i=idx;i<coins.length;i++){
            if(coins[i]<=Target){
                inner.add(coins[i]);
                Solve(coins,Target-coins[i],ll,inner,i);
                inner.remove(inner.size()-1);
            }
        }
    }
}