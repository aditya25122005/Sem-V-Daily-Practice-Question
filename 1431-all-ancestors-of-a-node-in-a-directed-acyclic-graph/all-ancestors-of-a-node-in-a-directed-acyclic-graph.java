class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        int [] in= new int[n];

        for(int[] E:edges){
            int from=E[0];
            int to= E[1];
            map.get(from).add(to);
            in[to]++;

        }
        List<List<Integer>> ancestor= new ArrayList<>();
        for(int i=0;i<n;i++){
            ancestor.add(new ArrayList<>());
        }
        Queue<Integer> q= new LinkedList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int u=q.poll();
            for(int nbrs:map.get(u)){
                if(!ancestor.get(nbrs).contains(u)){
                    ancestor.get(nbrs).add(u);
                }
                for(int x:ancestor.get(u)){
                    if(!ancestor.get(nbrs).contains(x)){
                        ancestor.get(nbrs).add(x);
                    }
                }
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        for(List<Integer> l:ancestor){
            Collections.sort(l);
        }
        return ancestor;
       
    }
}