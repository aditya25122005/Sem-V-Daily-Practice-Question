class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
       
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:deck){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int minFreq= Integer.MAX_VALUE;

        for(int key:map.keySet()){
            int val= map.get(key);
            minFreq=Math.min(minFreq,val);
        }
        for(int x=2;x<=minFreq;x++){
            boolean isOk=true;
            for(int key:map.keySet()){
                int freq=map.get(key);
                if(freq%x!=0){
                    isOk=false;
                }
            }
            if(isOk){
                return true;
            }
        }
        return false;

        
    }
}