class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ll= new ArrayList<>();
        List<Integer>inner= new ArrayList<>();
        Arrays.sort(candidates);
        Solve(candidates,target,inner,ll,0);
        return ll;



    }
    public static void Solve(int[] coins, int amount, List<Integer> inner, List<List<Integer>> ll, int idx){

    if(amount==0){
        ll.add(new ArrayList<>(inner));
        return;
    }
        
    for(int i=idx;i<coins.length;i++){

        if(i>idx && coins[i-1]==coins[i]){ // Already done for i-1th coin
            continue;
        }
        if(amount>=coins[i]){
            inner.add(coins[i]);
            Solve(coins,amount-coins[i],inner,ll,i+1);
            inner.remove(inner.size()-1);
        }
    }

    }
}