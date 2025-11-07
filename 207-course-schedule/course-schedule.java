class Solution {
    private HashMap<Integer,List<Integer>> map;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        map= new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int v1=prerequisites[i][0];
            int v2=prerequisites[i][1];

            map.get(v2).add(v1);
        }
        return isCycle();


    }
    public int[] indegree(){
        int [] in= new int[map.size()];
        for(int v2:map.keySet()){       //v2->v1
            for(int v1:map.get(v2)){//0->1 ,1->0
                in[v1]++;
            }
        }
        return in;
    }
    public int[] outdegree(){
        int[] out= new int[map.size()];
        for(int v1:map.keySet()){           //v1->v2
            for(int v2:map.get(v1)){ //0-> 1 , 1->0
                out[v1]++;
            }
        }
        return out;
    }
    public boolean isCycle(){
        Queue<Integer> q= new LinkedList<>();
        int [] in= indegree();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        int c=0;
        while(!q.isEmpty()){
            int r= q.poll();
            c++;
            for(int nbrs: map.get(r)){
                in[nbrs]--;
                if(in[nbrs]==0) q.add(nbrs);
            }
        }
        return c==map.size();
    }
}