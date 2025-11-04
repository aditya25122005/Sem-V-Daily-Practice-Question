class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll= new ArrayList<>();
        Solve(graph,ans,ll,0);
        return ans;

    }
    public static void Solve(int[][] graph, List<List<Integer>> ans,List<Integer>ll, int node){
        ll.add(node);
        if(ll.get(ll.size()-1)==graph.length-1){
            ans.add(new ArrayList<>(ll));
            return;
        }

        int[] arr= graph[node];
        for(int i=0;i<arr.length;i++){
            Solve(graph,ans,ll,arr[i]);
            ll.remove(ll.size()-1);
        }
    }
}