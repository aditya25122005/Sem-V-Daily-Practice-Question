class Solution {
    public double maxProbability(int n, int[][] edges, double[] success, int start, int end) {
        HashMap<Integer,HashMap<Integer,Double>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double p=success[i];
            map.get(u).put(v,p);
            map.get(v).put(u,p);
        }
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> Double.compare(b.prob,a.prob));
        double [] bestProb =new double[n];

        pq.add(new Pair(start,1.0));

        while(!pq.isEmpty()){
            Pair rp= pq.poll();
            int vtx=rp.vtx;
            double prob=rp.prob;

            if(prob>bestProb[vtx]) bestProb[vtx]=prob;
            if(vtx==end){
                return prob;
            }
            for(int nbrs:map.get(vtx).keySet()){

                double newProb=prob*map.get(vtx).get(nbrs);
                if(bestProb[nbrs]<newProb){
                    bestProb[nbrs]=newProb;
                    pq.add(new Pair(nbrs,bestProb[nbrs]));
                }
            }

        }
        return (double)0;
    }
    class Pair{
        int vtx;
        double prob;

        public Pair(int vtx, double prob){
            this.vtx=vtx;
            this.prob=prob;
        }

    }
}