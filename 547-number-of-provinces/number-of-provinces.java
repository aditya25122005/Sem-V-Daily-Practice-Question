class Solution {
    public int findCircleNum(int[][] isConnected) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<isConnected.length;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(i!=j &&isConnected[i][j]==1){
                    map.get(i).add(j);
                }
            }
        }
        Queue<Integer> q= new LinkedList<>();
        HashSet<Integer> visited= new HashSet<>();
        int c=0;
        for(int key:map.keySet()){
            if(visited.contains(key)){
                continue;
            }
            c++;
            q.add(key);
            while(!q.isEmpty()){
                //Remove
                int rm=q.poll();

                // Ignore
                if(visited.contains(rm)){
                    continue;
                }
                // Mark visited
                visited.add(rm);

                // Add unvisited neighbours
                for(int nbrs:map.get(rm)){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }

        }
        return c;
        
    }
}