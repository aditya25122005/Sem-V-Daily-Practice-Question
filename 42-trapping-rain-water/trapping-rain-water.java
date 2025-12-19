class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int [] pre= new int[height.length];
        int [] suf= new int[height.length];
        //       |\  -   |
        // 0 1 1 2 2 2 2 3 3 3 3 3
        // 3 3 3 3 3 3 3 3 2 2 2 1
        pre[0]=height[0];
        for(int i=1;i<height.length;i++){
            pre[i]=Math.max(height[i],pre[i-1]);
        }
        suf[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            suf[i]=Math.max(suf[i+1],height[i]);
        }
        int sum=0;
        for(int i=0;i<height.length;i++){
            sum+= Math.min(pre[i],suf[i])-height[i];
        }
        return sum;

    }
}