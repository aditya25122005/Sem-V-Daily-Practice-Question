class Solution {
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        List<List<Integer>> ll = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        int n = nums.length;
        Solve(0,n-1,ll,inner);
        System.out.println(ll);

        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new ArrayList<>());
        }
        for(int [] E: edges){
            int u= E[0];
            int v= E[1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        int ans =0;

        for(List<Integer> LL : ll){
            if(LL.size()==0) continue;
            int sum = 0;
            HashSet<Integer> nodes = new HashSet<>();
            for(int val: LL){
                nodes.add(val);
                sum+=nums[val];
            } 
            if(sum%2==1) continue;
            int comp = 0;
            
            boolean[] vis = new boolean[n];
            Queue<Integer> q = new LinkedList<>();
            q.add(LL.get(0));
            // vis[LL.get(0)] = true;
            while(!q.isEmpty()){
                int rm = q.poll();
                if(vis[rm]) continue;
                vis[rm]= true;
                for(int nbrs: map.get(rm)){
                    if(!vis[nbrs] && nodes.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }
            boolean all= true;
            for(int i=0;i<LL.size();i++){
                if(!vis[LL.get(i)]){
                    all=false;
                    break;
                }
            }
            if(all && sum%2==0){
                ans++;
            }
            
           
            
        }
        return ans;
        
    }
    public static void Solve(int curr,int last,List<List<Integer>> ll,List<Integer> inner){
        if(curr==last+1){
            ll.add(new ArrayList<>(inner));
            return;
        }

        inner.add(curr);
        Solve(curr+1,last,ll,inner);
        inner.remove(inner.size()-1);

        Solve(curr+1,last,ll,inner);
    }
}