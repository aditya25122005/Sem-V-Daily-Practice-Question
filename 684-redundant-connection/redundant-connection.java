class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu= new DSU();
        for(int i=1;i<=edges.length;i++){
            dsu.create(i);
        }
        for(int [] E: edges){
            if(dsu.union(E[0],E[1])){
                return new int[]{E[0], E[1]};
            }
        }
        return new int[]{};
    }
    static class DSU{
        class Node{
            int rank;
            int val;
            Node parent;
        }
        private HashMap<Integer,Node> map= new HashMap<>();

        public void create(int v){
            Node nn= new Node();
            nn.val=v;
            nn.parent=nn;
            nn.rank=0;
            map.put(v,nn);
        }

        public Node find(Node nn){
            if(nn.parent==nn){
                return nn;
            }
            Node n = find(nn.parent);
            nn.parent=n;
            return n;
        }


        public boolean union(int v1, int v2){
            Node re1= find(map.get(v1));
            Node re2= find(map.get(v2));
            if(re1==re2){
                return true;
            }
            else{
                if(re1.rank> re2.rank){
                    re2.parent= re1;
                }
                else if(re1.rank== re2.rank){
                    re2.parent=re1;
                    re1.rank++;
                }
                else if(re1.rank<re2.rank){
                    re1.parent=re2.parent;
                }
            }
            return false;

        }
    }
}