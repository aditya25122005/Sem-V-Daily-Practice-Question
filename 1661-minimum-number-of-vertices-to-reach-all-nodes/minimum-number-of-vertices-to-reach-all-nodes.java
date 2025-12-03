class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] in= new int[n];
        for(int i=0;i<edges.size();i++){
            List<Integer> ll= edges.get(i);
            in[ll.get(1)]++;
        }
        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<in.length;i++){
            if(in[i]==0) ans.add(i);
        }
        return ans;
    }
}