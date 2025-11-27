class Solution {
    public int maxNumberOfFamilies(int n, int[][] seats) {
        HashMap<Integer,HashSet<Integer>> map= new HashMap<>();
        for(int i=0;i<seats.length;i++){
            if(!map.containsKey(seats[i][0])){
            map.put(seats[i][0],new HashSet<>());
            }
        }
        for(int i=0;i<seats.length;i++){
            
            map.get(seats[i][0]).add(seats[i][1]);
        }
        int c=0;
        for(int key:map.keySet()){
            boolean poss2=true;
            for(int i=2;i<=9;i++){
                if(map.get(key).contains(i)){
                    poss2=false;
                    break;
                }
            }
            if(poss2){
                c+=2;
                continue;
            }
            boolean left=true;
            for(int i=2;i<=5;i++){
                if(map.get(key).contains(i)){
                    left=false;
                    break;
                }
            }
            if(left){
                c++;
                continue;
            }
            boolean right=true;
            for(int i=6;i<=9;i++){
                if(map.get(key).contains(i)){
                    right=false;
                    break;
                }
            }
            if(right){
                c++;
                continue;
            }
            boolean mid= true;
            for(int i=4;i<=7;i++){
                if(map.get(key).contains(i)){
                    mid=false;
                    break;
                }
            }
            if(mid){
                c++;
                continue;
            }
        }
        return c+(n-map.size())*2;
    }
}