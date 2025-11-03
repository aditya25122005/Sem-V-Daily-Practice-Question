class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ll= new ArrayList<>();
        List<Integer> curr= new ArrayList<>();
        Solve(nums,ll,curr,0);
        return ll;
    }
    public static void Solve(int[] nums,List<List<Integer>> ll, List<Integer> curr, int idx){
        if(idx==nums.length){
            ll.add(new ArrayList<>(curr));
            return;
        }

        // dont add
        Solve(nums,ll,curr,idx+1);

        //add
        curr.add(nums[idx]);
        Solve(nums,ll,curr,idx+1);
        curr.remove(curr.size()-1);
    }
}