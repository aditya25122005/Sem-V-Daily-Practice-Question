class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length==0 && n>1){
            return -1;
        }
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=1;i<=n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<trust.length;i++){
            int [] a= trust[i];
            map.get(a[0]).add(a[1]);
        }
        for(int i=1;i<=n;i++){
            if(map.get(i).size()==0 && check(i,map)){
                return i;
            }
        }
        return -1;
    }
    public static boolean check(int i,HashMap<Integer,List<Integer>> map){ // check if i exists in every relation
        for(int key:map.keySet()){
            if(key==i){
                continue;
            }
            if(!map.get(key).contains(i)){
                return false;
            }
        }
        return true;
    }
}