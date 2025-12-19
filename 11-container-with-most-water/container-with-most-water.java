class Solution {
    public int maxArea(int[] height) {
        int n= height.length;
        int i=0;
        int j=n-1;
        int max=Integer.MIN_VALUE;
        while(i<j){
            int h=Math.min(height[i],height[j]);
            int w=j-i;
            max=Math.max(max,h*w);
            if(height[i]<height[j]){
                i++;
            }
            else j--;
        }
        return max;
    }
}