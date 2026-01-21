class Solution {
    public int trap(int[] height) {
        int n= height.length;
        int l=0;
        int r=n-1;
        int leftMax=0;
        int rightMax=0;
        int ans=0;
        while(l<=r){
            if(height[l]<=height[r]){
                if(leftMax>height[l]){
                    ans+= leftMax-height[l];
                }
                leftMax=Math.max(leftMax,height[l]);
                l++;
            }
            else{
                if(rightMax>height[r]){
                    ans+= rightMax-height[r];
                }
                rightMax=Math.max(rightMax,height[r]);
                r--;
            }
        }
        return ans;
    }
}