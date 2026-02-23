class Solution {
    public boolean validPath(int n, int[][] edges, int src, int des) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int [] E: edges){
            int u= E[0];
            int v= E[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        HashSet<Integer> visited= new HashSet<>();
        return hasPath(src,des,visited,map);
       
    }
    public static boolean hasPath(int src, int des, HashSet<Integer> visited,
    HashMap<Integer,List<Integer>> map){
        if(src==des){
            return true;
        }
        visited.add(src);
        for(int nbrs: map.get(src)){
            if(!visited.contains(nbrs)){
                boolean res= hasPath(nbrs,des,visited,map);
                if(res) return true;
            }
        }
        return false;

    }
}