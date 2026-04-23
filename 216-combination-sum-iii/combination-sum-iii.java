class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ll = new ArrayList<>();
        Solve(n,1,k,ans,ll);
        return ans;
    }
    public static void Solve(int target,int num, int K, List<List<Integer>> ans,
    List<Integer> ll){
        if(K<0){
            return;
        }
        if(target<0){
            return;
        }
        if(target==0 && K==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(num>9){
            return;
        }
        ll.add(num);
        Solve(target-num, num+1,K-1,ans,ll);
        ll.remove(ll.size()-1);
        Solve(target,num+1,K,ans,ll);

    }
}