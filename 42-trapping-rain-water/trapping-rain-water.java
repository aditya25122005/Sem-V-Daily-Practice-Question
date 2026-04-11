class Solution {
    public int trap(int[] height) {
        int [] pre = new int[height.length];
        pre[0]=height[0];
        for(int i=1;i<pre.length;i++){
            pre[i]=Math.max(height[i], pre[i-1]);
        }

        int [] suf = new int[height.length];
        suf[height.length-1]= height[height.length-1];
        for(int i=suf.length-2;i>=0;i--){
            suf[i]=Math.max(suf[i+1], height[i]);
        }

        int ans=0;
        for(int i=0;i<height.length;i++){
            int H= Math.min(suf[i], pre[i]);
            ans+= Math.max(0, H- height[i]);
        }
        return ans;
    }
}