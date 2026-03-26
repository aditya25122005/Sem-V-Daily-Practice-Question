class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new HashMap<>());
        }
        for(int [] E: flights){
            int u= E[0];
            int v= E[1];
            int price= E[2];
            map.get(u).put(v,price);
        }
        int [][] bestCost = new int[n][k+2];
        // 1 node tak k flights ka use karke jane par kitna cost hai wo store karenge
        for(int [] x: bestCost){
            Arrays.fill(x,-1);
        }

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));
        HashSet<Integer> visited = new HashSet<>();
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair rm= pq.poll();
            // if(visited.contains(rm.vtx)){
            //     continue;
            // }
            // visited.add(rm.vtx);
            if(rm.vtx==dst){
                return rm.cost;
            }
            if(rm.usedK>k) continue;
            for(int nbrs: map.get(rm.vtx).keySet()){
                
                    int newCost= rm.cost+ map.get(rm.vtx).get(nbrs);
                    if(bestCost[nbrs][rm.usedK+1]==-1 || bestCost[nbrs][rm.usedK+1]>newCost){
                        pq.add(new Pair(nbrs,rm.usedK+1,newCost));
                        bestCost[nbrs][rm.usedK+1]=newCost;
                    }
                
            }
        }
        return -1;

    }
    static class Pair{
        int vtx;
        int usedK;
        int cost;
        public Pair(int vtx, int usedK, int cost){
            this.vtx=vtx;
            this.usedK= usedK;
            this.cost= cost;
        }
    }
}