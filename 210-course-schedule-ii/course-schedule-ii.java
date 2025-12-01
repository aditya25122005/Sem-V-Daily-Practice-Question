class Solution {
    public int[] findOrder(int num, int[][] preq) {
        int[] ans=new int[num];
        int idx=0;
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<num;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<preq.length;i++){
            int v1= preq[i][0];
            int v2= preq[i][1];
            map.get(v2).add(v1);
        }
        int [] in= new int[num];
        for(int v1:map.keySet()){
            for(int v2:map.get(v1)){
                in[v2]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int rm=q.poll();
            ans[idx]=rm;
            idx++;

            for(int nbrs:map.get(rm)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        if(idx==ans.length){
            return ans;
        }
        return new int[]{};

    }
}