class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int [] ans= new int[2];
        int idx=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:map.keySet()){
            if(map.get(num)==2){
                ans[idx]=num;
                idx++;
                if(idx==2){
                    break;
                }
            }
        }
        return ans;
    }
}