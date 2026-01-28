class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> inner= new ArrayList<>();
        Solve(1,n,k,ans,inner);
        return ans;
        
    }
    public static void Solve(int idx,int n,int k,List<List<Integer>> ans,List<Integer> ll){
        if(ll.size()==k){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(idx>n){
            return;
        }

        ll.add(idx);
        Solve(idx+1,n,k,ans,ll);

        ll.remove(ll.size()-1);
        Solve(idx+1,n,k,ans,ll);
        // }

    }
}