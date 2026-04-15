class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n= words.length;
        int ans=Integer.MAX_VALUE;
        int step=0;
        for(int i=startIndex ;i<startIndex+n;i++){
            int idx = i%n;
            if(words[idx].equals(target)){
                ans=Math.min(ans,step);
            }
            step++;
        }
        // 2 
        step = 0;
        int i=startIndex;
        while(step<n){
            int idx=i;
            if(idx<0){
                idx = (i+n)%n;
            }
            if(words[idx].equals(target)){
                ans=Math.min(ans,step);
            }
            step++;
            i--;
       }
        return ans==Integer.MAX_VALUE? -1 : ans;
    }
}