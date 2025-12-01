class Solution {
    public int findCenter(int[][] edges) {
        int [] in= new int[edges.length+2];
        for(int i=0;i<edges.length;i++){
            in[edges[i][1]]++;
            in[edges[i][0]]++;
        }
        for(int i=1;i<in.length;i++){
            if(in[i]==edges.length) return i;
        }
        return -1;

    }
}