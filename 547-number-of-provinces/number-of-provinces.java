class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=1;i<=isConnected.length;i++){
            map.put(i, new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            int [] A= isConnected[i];
            for(int j=0;j<A.length;j++){
                int u=i+1;
                int v= A[j];
                if(i+1 != j+1){
                    if(A[j]==1){
                        map.get(i+1).add(j+1);
                    }
                }
            }
        }
        System.out.println(map);
        int c=0;
        HashSet<Integer> visited= new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        for(int i=1;i<=isConnected.length;i++){
            
            if(!visited.contains(i)){
            c++;
            q.add(i);
            while(!q.isEmpty()){
                int rm=q.poll();
                if(visited.contains(rm)){
                    continue;
                }
                visited.add(rm);
                for(int nbrs: map.get(rm)){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }
            }
        }
        return c;
    }
}