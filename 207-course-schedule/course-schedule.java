class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        HashMap<Integer,List<Integer>>map= new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i, new ArrayList<>());

        }
        int [] in= new int[numCourses];
        for(int [] E: pre){
            int u= E[0];
            int v= E[1];
            map.get(v).add(u);
            in[u]++;
        }

        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int rm= q.poll();

            for(int nbrs:map.get(rm)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        boolean Ok=true;
        for(int num:in){
            if(num!=0) {
                Ok=false;
                break;
            }
        }
        return Ok;
    }
}