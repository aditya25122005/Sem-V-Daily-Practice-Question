class Solution {
    public int edgeScore(int[] edges) {
        long maxSum=0;
        int ansNode=0;
        long [] incoming= new long[edges.length];
        for(int i=0;i<edges.length;i++){
            incoming[edges[i]] += i;
        }
        for(int i=0;i<incoming.length;i++){
            if(incoming[i]>maxSum){
                maxSum=incoming[i];
                ansNode=i;
            }
        }
        return ansNode;
    }
}