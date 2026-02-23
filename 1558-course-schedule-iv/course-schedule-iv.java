class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] pre, int[][] queries) {

        HashMap<Integer,List<Integer>> map= new HashMap<>();
        HashMap<Integer,List<Integer>> path= new HashMap<>();
        for(int i=0;i<numCourses;i++){
            map.put(i, new ArrayList<>());
            path.put(i, new ArrayList<>());
        }

        for(int [] E:pre ){
            int u= E[0];
            int v= E[1];
            map.get(u).add(v);
        }

        List<Boolean> ll= new ArrayList<>();


       for(int u=0;u<numCourses;u++){
            Queue<Integer> q= new LinkedList<>();
            HashSet<Integer> visited= new HashSet<>();
            q.add(u);
            while(!q.isEmpty()){
                int rm= q.poll();
                if(visited.contains(rm)) continue;
                visited.add(rm);

                for(int nbrs : map.get(rm)){
                    if(!visited.contains(nbrs)){
                        path.get(u).add(nbrs);
                        q.add(nbrs);
                    }
                }
            }
          
        }

        for(int[] Q: queries){
            int u= Q[0];
            int v= Q[1];
            if(path.get(u).contains(v)){
                ll.add(true);
            }
            else{
                ll.add(false);
            }
        }
        return ll;

    }
}