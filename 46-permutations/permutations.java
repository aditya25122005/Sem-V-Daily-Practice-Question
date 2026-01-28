class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        boolean [] taken= new boolean[nums.length];
        Solve(nums,ans,ll,taken);
        return ans;
    }
    public static void Solve(int[] arr,List<List<Integer>> ans,List<Integer> ll, 
    boolean [] taken ){
        if(ll.size()==arr.length){
            ans.add(new ArrayList<>(ll));
            return;
        }
        


        for(int i=0;i<arr.length;i++){
            if(!taken[i]){
                ll.add(arr[i]);
                taken[i]= true;
                Solve(arr,ans,ll,taken);

                taken[i]= false;
                ll.remove(ll.size()-1); // backtrack
            }
        }
       
        
    }
}