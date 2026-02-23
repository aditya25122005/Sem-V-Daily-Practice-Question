class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] pre, int[][] queries) {

        HashMap<Integer,List<Integer>> map= new HashMap<>();
        HashMap<Integer,Integer> path= new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i, new ArrayList<>());
        }

        for(int [] E:pre ){
            int u= E[0];
            int v= E[1];
            map.get(u).add(v);
        }

       
        
        List<Boolean> ll= new ArrayList<>();


        for(int [] Q: queries){
            Queue<Integer> q= new LinkedList<>();
            HashSet<Integer> visited= new HashSet<>();
            int src= Q[0];
            int des= Q[1];
            q.add(src);
            boolean mark=false;
            while(!q.isEmpty()){
                int rm= q.poll();

                if(visited.contains(rm)) continue;

                visited.add(rm);

                if(rm==des){
                    ll.add(true);
                    mark=true;
                    break;
                }
                for(int nbrs : map.get(rm)){
                    if(!visited.contains(nbrs)){
                        q.add(nbrs);
                    }
                }
            }
            if(!mark) ll.add(false);

        }
        return ll;

    }
}