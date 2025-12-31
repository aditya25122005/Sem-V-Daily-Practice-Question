class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu= new DSU();
        for(int i=1;i<=edges.length;i++){
            dsu.create(i);
        }
        for(int [] A:edges){
            if(dsu.union(A[0],A[1])) return A; 
        }
        return new int[]{};
    }

    class DSU{
        class Node{
            int rank;
            Node parent;
            int val;

        }
        private HashMap<Integer,Node> map= new HashMap<>();

        public void create(int v){
            Node nn= new Node();
            nn.val=v;
            nn.parent=nn;
            nn.rank=0;
            map.put(v,nn);
        }

        // public int find(int v){
        //     Node nn=map.get(v);
        //     return find(nn).val;
        // }
        private Node find(Node nn){
            if(nn.parent==nn){
                return nn;
            }
            Node n= find(nn.parent);
            nn.parent=n;
            return n;
        }

        public boolean union(int v1, int v2){
            Node nn1= map.get(v1);
            Node nn2= map.get(v2);


            Node re1= find(nn1);
            Node re2= find(nn2);
            if(re1==re2){
                return true;
            }
            else{
                if(re1.rank>re2.rank){
                    re2.parent=re1;
                }
                else if(re1.rank<re2.rank){
                    re1.parent=re2;
                }
                else if(re1.rank==re2.rank){
                    re2.parent=re1;
                    re1.rank++;
                }
                return false;
            }

        }

        
    }
}