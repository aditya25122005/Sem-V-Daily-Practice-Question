class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        HashSet<Integer> visited= new HashSet<>();
        while(!q.isEmpty()){
            int rm=q.poll();
            if(visited.contains(rm)){
                continue;
            }
            visited.add(rm);
            for(int num:rooms.get(rm)){
                if(!visited.contains(num)){
                    q.add(num);
                }
            }
        }
        return visited.size()==rooms.size();
    }
}