class Solution {
    public boolean isGood(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        int last = nums.length-1;
        if(!map.containsKey(last) || map.get(last)!=2) return false;
        for(int i=1;i<last;i++){
            if(!map.containsKey(i) || map.get(i)!=1){
                return false;
            }
        }
        return true;
    }
}