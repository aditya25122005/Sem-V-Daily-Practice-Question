/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        Queue<Employee> q = new LinkedList<>();
        int total=0;
        q.add(map.get(id));
        while(!q.isEmpty()){
            Employee rm = q.poll();
            total+= rm.importance;
            for(int nbrs : rm.subordinates){
                q.add(map.get(nbrs));
            }
        }
        return total;
    }
}