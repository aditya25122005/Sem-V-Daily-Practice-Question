class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n>1) return -1;
        HashSet<Integer> hh= new HashSet<>();
        boolean first=false;
        int judgeCan=-1;
        for(int [] a:trust){
            hh.add(a[0]);
        }
        for(int i=1;i<=n;i++){
            if(!hh.contains(i)){
                judgeCan=i;
                first=true;
            }
        }
        if(!first){
            return -1;
        }
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int[]a:trust){
            
            map.put(a[0],a[1]);
            
        }
        for(int[]a:trust){
            if(a[1]==judgeCan){
            map.put(a[0],a[1]);
            }
        }
        for(int key:map.keySet()){
            if(key==judgeCan) return -1;
            if(map.get(key)!=judgeCan) return -1;
        }
        return judgeCan;
        
    }
}