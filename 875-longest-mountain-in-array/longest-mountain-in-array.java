class Solution {
    public int longestMountain(int[] arr) {
        // 0,0,1,2,0,0,1 // continuous decreasing in back
        // 1,0,0,2,1,0,0 // continuous decreasing in right

        int [] left = new int[arr.length];
        left[0]=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1]){
                left[i]=left[i-1]+1;
            }
            else{
                left[i]=0;
            }
        }
        int [] right = new int[arr.length];
        right[arr.length-1]=0;
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]> arr[i+1]){
                right[i]= right[i+1]+1;
            }
            else{
                right[i]=0;
            }
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(left[i]==0 || right[i]==0){

            }
            else{
                ans= Math.max(ans, left[i]+right[i]+1);
            }
        }
        return ans;

    }
}