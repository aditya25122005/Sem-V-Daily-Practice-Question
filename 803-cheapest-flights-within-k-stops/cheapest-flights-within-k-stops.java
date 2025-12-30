class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src==dst) return 0;
        HashMap<Integer,HashMap<Integer,Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(int [] A:flights){
            map.get(A[0]).put(A[1],A[2]);
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->a.cost-b.cost);
        HashSet<Integer> visited= new HashSet<>();
        int [][] best= new int[n][k+2]; // for 3 nodes total in a row we have to take 2 flights so k+1; indexing is 0 based , so 0,1,2(when a sigle node in mid path)
        for(int i=0;i<n;i++){
            Arrays.fill(best[i],Integer.MAX_VALUE);
        }
        int visitedK=0;
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair rm=pq.poll();
            int v=rm.vtx;
            int cost=rm.cost;
            int stop=rm.stopUsed;

            if(v==dst) return cost;
            if(stop>k) continue;

            for(int nbrs:map.get(rm.vtx).keySet()){
                int Newcost= cost+ map.get(v).get(nbrs);
                if(Newcost<best[nbrs][stop+1]){
                    best[nbrs][stop+1] = Newcost;
                    pq.add(new Pair(nbrs, Newcost, stop+1));
                }
                
                
            }

        }
        return -1;
        
    }
    class Pair{
        int vtx;
        int cost;
        int stopUsed;
        public Pair(int vtx, int cost, int stopUsed){
            this.vtx=vtx;
            this.cost=cost;
            this.stopUsed=stopUsed;

        }
    }
}