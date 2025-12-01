class Solution {
    public boolean canFinish(int num, int[][] preq) {
        HashMap<Integer,List<Integer>> graph= new HashMap<>();
        for(int i=0;i<num;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i=0;i<preq.length;i++){
            int a= preq[i][0];
            int b= preq[i][1];
            graph.get(a).add(b);
        }
        int[] in= new int[num];
        for(int v1:graph.keySet()){
            for(int v2:graph.get(v1)){
                in[v2]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        int c=0;
        // HashSet<Integer> visited= new HashSet<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int rm= q.poll();
            c++;
            
            for(int nbrs:graph.get(rm)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }

        }
        return c==num;
    }
}