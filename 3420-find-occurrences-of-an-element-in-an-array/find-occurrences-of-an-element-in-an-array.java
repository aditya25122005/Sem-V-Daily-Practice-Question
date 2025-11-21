class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int[] ans= new int[queries.length];
        HashMap<Integer,Integer> map= new HashMap<>();
        int idx=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                map.put(idx,i);
                idx++;
            }
        }
        int idxx=0;
        for(int i:queries){
            if(map.containsKey(i)){
                ans[idxx]=map.get(i);
                idxx++;
            }
            else{
                ans[idxx]=-1;
                idxx++;
            }
        
        }
        return ans;
    }
}