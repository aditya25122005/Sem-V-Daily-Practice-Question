class Solution {
    public int maximumSum(int[] arr) {
        int ans=0;
        int max=arr[0];
        int onedel=0;
        int nodel=arr[0];
        for(int i=1;i<arr.length;i++){
            onedel=Math.max(onedel+arr[i],nodel);
            nodel=Math.max(nodel+arr[i],arr[i]);
            max=Math.max(max,Math.max(onedel,nodel));
        }
        return max;


    }
}