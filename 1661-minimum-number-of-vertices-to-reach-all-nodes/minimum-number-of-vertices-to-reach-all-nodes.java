class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.size();i++){
            map.get(edges.get(i).get(0)).add(edges.get(i).get(1));
        }
        int [] in= new int[n];
        for(int v1:map.keySet()){
            for(int v2:map.get(v1)){
                in[v2]++;
            }
        }
        List<Integer> ll= new ArrayList<>();
        for(int i=0;i<n;i++){
            if(in[i]==0){
                ll.add(i);
            }
        }
        return ll;
    }
}