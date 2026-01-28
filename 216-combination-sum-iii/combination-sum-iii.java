class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ll= new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        Solve(1,n,k,ll,inner);
        return ll;
        
    }
    public static void Solve(int idx,int target, int k, List<List<Integer>> ll, List<Integer> inner){
        if(inner.size()==k && target==0){
            ll.add(new ArrayList<>(inner));
            return;
        }
        if(idx>9){
            return;
        }
        if(target>=idx){
            inner.add(idx);
            Solve(idx+1,target-idx,k,ll,inner);

            inner.remove(inner.size()-1);
        }
        Solve(idx+1,target,k,ll,inner);
    }
}