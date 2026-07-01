class Solution {
    public boolean canFinish(int num, int[][] pre) {
        // b->a
        int [] in = new int[num];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<num;i++){
            map.put(i, new ArrayList<>());
        }
        for(int [] A: pre){
            int u = A[0];
            int v = A[1];
            map.get(v).add(u);
            in[u]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        int c = 0;
        while(!q.isEmpty()){
            int rm = q.poll();
            c++;
            for(int nbrs: map.get(rm)){
                in[nbrs]--;
                if(in[nbrs]==0) q.add(nbrs);
            }
        }
        return c==num;


    }
}