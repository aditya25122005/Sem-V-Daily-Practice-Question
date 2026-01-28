class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> inner= new ArrayList<>();
        Arrays.sort(candidates);
        Solve(candidates,0,target,0,ans,inner);
        return ans;

    }
    public static void Solve(int[] arr, int idx, int target,int curr,List<List<Integer>> ans,List<Integer> inner){
        if(target==curr){
            ans.add(new ArrayList<>(inner));
            return;
        }
        if(idx>=arr.length){
            return;
        }
        // for(int i=idx;i<arr.length;i++){
            if(arr[idx]+curr<=target){
                
                inner.add(arr[idx]);
       
                Solve(arr,idx,target,curr+arr[idx],ans,inner);

                inner.remove(inner.size()-1);
                Solve(arr,idx+1,target,curr,ans,inner);
            }
        // }

    }
}