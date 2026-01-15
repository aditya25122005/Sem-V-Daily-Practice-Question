class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int maxH=1;
        int curr=1;
        for(int i=1;i<hBars.length;i++){
            if(hBars[i]-1== hBars[i-1]){
                curr++;
                maxH=Math.max(maxH,curr);
            }
            else{
                curr=1;
            }
        }
        int maxV=1;
        curr=1;
        for(int i=1;i<vBars.length;i++){
            if(vBars[i]-1==vBars[i-1]){
                curr++;
                maxV=Math.max(maxV,curr);
            }
            else{
                curr=1;
            }
        }
        int side= Math.min(maxH,maxV)+1;
        return side*side;
    }
}