class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        HashSet<Integer> hh= new HashSet<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
            hh.add(num);
        }
        int ans=0;
        for(int v:hh){
            if(map.containsKey(v+1)){
                ans=Math.max(ans,map.get(v)+map.get(v+1));
            }
        }
        return ans;
    }
}