class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        Solve(nums,0,ans,ll);
        return ans;

    }
    public static void Solve(int[] arr, int idx, List<List<Integer>> ans,List<Integer> ll){
        if(idx==arr.length){
            ans.add(new ArrayList<>(ll));
            return;
        }

        ll.add(arr[idx]);
        Solve(arr,idx+1,ans,ll);

        ll.remove(ll.size()-1);
        Solve(arr,idx+1,ans,ll);

    }
}