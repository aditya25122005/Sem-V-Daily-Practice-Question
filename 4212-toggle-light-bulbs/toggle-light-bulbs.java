class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num: bulbs){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        List<Integer> ans= new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key)%2==1){
                ans.add(key);
            }
        }
        Collections.sort(ans);
        return ans;
        // boolean[] status= new boolean[101];
        // for(int bulb:bulbs){
        //     status[bulb] = !status[bulb];
        // }
        // HashSet<Integer> hh= new HashSet<>(bulbs);
        // List<Integer> ans= new ArrayList<>();
        // for(int bulb:hh){
        //     if(status[bulb]) ans.add(bulb);
        // }
        // Collections.sort(ans);
        // return ans;
    }
}