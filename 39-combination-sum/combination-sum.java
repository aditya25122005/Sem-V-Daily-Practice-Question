class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ll= new ArrayList<>();
        List<Integer> curr= new ArrayList<>();

        Solve(candidates,ll,curr,target,0);
        return ll;

    }
    public static void Solve(int[] arr, List<List<Integer>> ll, List<Integer> curr, int target, int idx){
        if(target==0){
            ll.add(new ArrayList<>(curr));
            return;
        }
        if(idx>=arr.length){
            return;
        }
        
 
            if(arr[idx]<=target){
                curr.add(arr[idx]);
                Solve(arr,ll,curr,target-arr[idx],idx);
                curr.remove(curr.get(curr.size()-1));
            }
            
            Solve(arr,ll,curr,target,idx+1);
       

    }
}