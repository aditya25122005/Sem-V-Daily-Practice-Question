class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        } 
        List<List<Integer>> ans= new ArrayList<>();
        while(map.size()>0){
            List<Integer> ll= new ArrayList<>();
            List<Integer> toremove= new ArrayList<>();
            for(int key: map.keySet()){
                ll.add(key);
                int old= map.get(key);
                map.put(key,old-1);

                if(map.get(key)==0) toremove.add(key);
            }
            ans.add(new ArrayList<>(ll));
            for(int k:toremove){
                map.remove(k);
            }
        }
        return ans;
    }
}