class Solution {
    public int trap(int[] ht) {
        //0 1 1 2 2 2 2 3 3 3 3 3
        //3 3 3 3 3 3 3 3 2 2 2 1
        int [] pre= new int[ht.length];
        int [] suf= new int[ht.length];
        pre[0]=ht[0];
        for(int i=1;i<pre.length;i++){
            pre[i]=Math.max(pre[i-1],ht[i]);
        }
        suf[ht.length-1]=ht[ht.length-1];
        for(int i=ht.length-2;i>=0;i--){
            suf[i]=Math.max(suf[i+1],ht[i]);
        }
        int ans=0;
        for(int i=0;i<ht.length;i++){
            ans+= Math.min(pre[i],suf[i])-ht[i];
        }
        return ans;


    }
}