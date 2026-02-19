class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<List<String>> ans= new ArrayList<>();
        TreeSet<String> dishes= new TreeSet<>();

        TreeMap<String,TreeMap<String,Integer>> map= new TreeMap<>();
        for(List<String> ll: orders){
            String table= ll.get(1);
            String dish= ll.get(2);
            dishes.add(dish);
            map.putIfAbsent(table,new TreeMap<>());
            TreeMap<String,Integer> inner= map.get(table); // inner map aa gya
            inner.put(dish,inner.getOrDefault(dish,0)+1); 
           
        }


        

        List<String> inner= new ArrayList<>();
        inner.add("Table");
        for(String dish: dishes){
            inner.add(dish);
        }
        ans.add(new ArrayList<>(inner));
        for(String table : map.keySet()){
            List<String>inn= new ArrayList<>();
            inn.add(table);
            for(String food: dishes){
                if(!map.get(table).containsKey(food)){
                    inn.add("0");
                }
                else{
                    inn.add(String.valueOf(map.get(table).get(food)));
                }
            }
            ans.add(new ArrayList<>(inn));
            
        }
        Collections.sort(ans.subList(1,ans.size()),(a,b)->Integer.compare(Integer.parseInt(a.get(0)) ,Integer.parseInt(b.get(0)) ));
        return ans;

    }
}