class Solution {
    public int[] findOrder(int n, int[][] pre) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int [] E: pre){
            int u= E[0];
            int v= E[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        int [] ans= new int[n];
        int idx=0;
        // 1,0-> 1-->0
        // must do course b to take curse a
        int [] in = new int[n];
        for(int [] A: pre){
            int u= A[0];
            int v= A[1];

            in[u]++;
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                ans[idx++]=i;
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int rm= q.poll();

            for(int nbrs: map.get(rm)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                    ans[idx++]= nbrs;
                }
            }

        }
        if(idx<n) return new int[]{};
        return ans;



    }
}