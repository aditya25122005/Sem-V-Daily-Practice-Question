class Solution {
    public int maxDistance(int[] colors) {
     
        int ans = Integer.MIN_VALUE;
        for(int j=0;j<colors.length;j++){
            int oldcolor = colors[j];
            int idx = j;
            for(int i=1;i<colors.length;i++){
                if(colors[i]!=oldcolor){
                    ans= Math.max(ans, i-idx);
                }
            }
        }
        
        return ans;
    }
}