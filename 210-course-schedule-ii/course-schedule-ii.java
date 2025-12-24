class Solution {
    public int[] findOrder(int num, int[][] preq) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<num;i++){
            map.put(i,new ArrayList<>());
        }
        for(int[]A:preq){
            map.get(A[1]).add(A[0]);
        }

        int [] in= new int[num];
        for(int u:map.keySet()){
            for(int v:map.get(u)){
                in[v]++;
            }
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans= new ArrayList<>();
        while(!q.isEmpty()){
            int rm=q.poll();
            ans.add(rm);

            for(int nbrs:map.get(rm)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        int [] res= new int[ans.size()];
        if(ans.size()!=num) {
            return new int[]{};
        }
        else{
            for(int i=0;i<ans.size();i++){
                res[i]=ans.get(i);
            }
        }
        return res;
    }
}