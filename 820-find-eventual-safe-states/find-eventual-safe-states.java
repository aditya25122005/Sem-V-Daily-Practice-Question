class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ll= new ArrayList<>();
        int n= graph.length;
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }

// 5, 6, 2, 4
    int [] in = new int[graph.length];
    for(int i=0;i<graph.length;i++){
        for(int v: graph[i]){
            map.get(v).add(i);
            in[i]++;
        }
    }
    Queue<Integer> q= new LinkedList<>();

    for(int i=0;i<in.length;i++){
        if(in[i]==0) q.add(i);
    }
    while(!q.isEmpty()){
        int rm= q.poll();
        ll.add(rm);


        for(int nbrs:map.get(rm)){
            in[nbrs]--;
            if(in[nbrs]==0){
                q.add(nbrs);
            }
        }
    }
    Collections.sort(ll);
        return ll;
    }
}