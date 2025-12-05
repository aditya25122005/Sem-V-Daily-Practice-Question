class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ll= new ArrayList<>();
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int num:groupSizes){
            if(!map.containsKey(num)){
                map.put(num,new ArrayList<>());
            }
        }
        for(int i=0;i<groupSizes.length;i++){
            map.get(groupSizes[i]).add(i);
            // 3->012346
            // 1->5
        }
        for(int key:map.keySet()){
            List<Integer> curr= new ArrayList<>();
            for(int item:map.get(key)){
                curr.add(item);
                if(curr.size()==key){
                    ll.add(curr);
                    curr=new ArrayList<>();
                }
               
            }
        }
        return ll;
    }
}