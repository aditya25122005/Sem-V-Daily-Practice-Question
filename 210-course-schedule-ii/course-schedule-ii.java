class Solution {
    private HashMap<Integer,List<Integer>> map;
    public int[] findOrder(int num, int[][] req) {
        map= new HashMap<>();
        for(int i=0;i<num;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<req.length;i++){
            int v1=req[i][0];
            int v2=req[i][1];
            map.get(v2).add(v1);
        }
        List<Integer> ans= topological_sort();
        int[] arr= new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            arr[i]=ans.get(i);
        }
        return arr;

    }
    public int[] indegree(){
        int [] in= new int[map.size()];
        for(int v2:map.keySet()){
            for(int v1:map.get(v2)){ // v2 -> v1
                in[v1]++;
            }
        }
        return in;
    }
    public List<Integer> topological_sort(){
        int [] in= indegree();
        Queue<Integer> q= new LinkedList<>();
        List<Integer> ll= new ArrayList<>();
        int c=0;
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int r= q.poll();
            c++;
            ll.add(r);
            for(int nbrs:map.get(r)){
                in[nbrs]--;
                if(in[nbrs]==0){
                    q.add(nbrs);
                }
            }
        }
        if(c==map.size()){
            return ll;
        }else{
            return new ArrayList<>();
        }
    }
}