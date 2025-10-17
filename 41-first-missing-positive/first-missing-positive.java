class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            if(num>0){
                map.put(num,1);
            }
        }
        int check=1;
        for(int key:map.keySet()){
            if(!map.containsKey(check)){
                return check;
            }
            else{
                check++;
            }
        }
        return check;
    }
}