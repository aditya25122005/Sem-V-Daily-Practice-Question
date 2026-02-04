class Solution {
    public boolean isPossibleDivide(int[] hand, int k) {
        TreeMap<Integer,Integer> map= new TreeMap<>();

        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        
        while(!map.isEmpty()){
            int start=map.firstKey();
            for(int i=0;i<k;i++){
                int val= start+i;
                if(!map.containsKey(val)) return false;
                
                map.put(val,map.get(val)-1);

                if(map.get(val)==0){
                    map.remove(val);
                }

            }
        }
        return true;
    }
}