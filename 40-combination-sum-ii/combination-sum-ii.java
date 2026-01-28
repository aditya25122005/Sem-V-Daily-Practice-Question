class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        Arrays.sort(candidates);
        Solve(candidates,0,target,ans,ll);
        return ans;

    }
    public static void Solve(int[] arr, int idx, int target,List<List<Integer>> ans,List<Integer> ll){
        if(target==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        if(idx==arr.length){
            return;
        }
        if(target>= arr[idx]){
            ll.add(arr[idx]);
            Solve(arr,idx+1,target-arr[idx],ans,ll);
            while(idx+1<arr.length && arr[idx+1]==arr[idx]) idx++;
            ll.remove(ll.size()-1);
        }
        Solve(arr,idx+1,target,ans,ll);
    }
}