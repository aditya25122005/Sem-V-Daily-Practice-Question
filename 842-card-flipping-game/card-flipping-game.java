class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        // kon answer nahi hoga-> 1, 4
        HashSet<Integer> bad= new HashSet<>();
        for(int i=0;i<fronts.length;i++){
            if(fronts[i]==backs[i]){
                bad.add(fronts[i]);
            }
        }
        int min=Integer.MAX_VALUE;

        for(int num:fronts){
            if(!bad.contains(num)){
                min=Math.min(min,num);
            }
        }
        for(int num:backs){
            if(!bad.contains(num)){
                min=Math.min(min,num);
            }
        }
        return min==Integer.MAX_VALUE? 0:min;
    }
}