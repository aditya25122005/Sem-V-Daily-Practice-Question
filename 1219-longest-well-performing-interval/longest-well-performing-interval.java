class Solution {
    public int longestWPI(int[] hours) {
        int curr =0 ;
        //1,2,1,0,-1,-2,-3
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);
        int ans=0;
        for(int i=0;i<hours.length;i++){
            if(hours[i]>8){
                curr++;
            }
            else if(hours[i]<=8){
                curr--;
            }
          
            if(curr>0){
                ans=Math.max(ans,i+1);
            }
            else if(map.containsKey(curr-1)){
                ans=Math.max(ans,i- map.get(curr-1));
            }
            if(!map.containsKey(curr)){
                map.put(curr,i);
            }
        }
        return ans;
    }
}