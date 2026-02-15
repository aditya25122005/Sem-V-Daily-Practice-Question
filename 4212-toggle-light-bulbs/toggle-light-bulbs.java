class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] status= new boolean[101];
        for(int bulb:bulbs){
            status[bulb] = !status[bulb];
        }
        HashSet<Integer> hh= new HashSet<>(bulbs);
        List<Integer> ans= new ArrayList<>();
        for(int bulb:hh){
            if(status[bulb]) ans.add(bulb);
        }
        Collections.sort(ans);
        return ans;
    }
}