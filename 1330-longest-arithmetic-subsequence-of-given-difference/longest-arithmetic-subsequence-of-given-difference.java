class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        // Integer [][] dp= new Integer[arr.length][arr.length+1];
        HashMap<Integer,Integer> map= new HashMap<>();
        int max=0;
        for(int i=0;i<arr.length;i++){
            int curr=1;
            if(map.containsKey(arr[i]-diff)){
                curr+= map.get(arr[i]-diff);
            }
            map.put(arr[i],curr);
            max=Math.max(max,curr);
        }
        return max;

        // return Solve(arr,0,diff,-1,dp);
    }
    // MLE

    // public static int Solve(int[] arr, int idx, int diff, int prev,Integer [][]dp){
    //     if(idx==arr.length){
    //         return 0;
    //     }
    //     if(prev!=-1){
    //     if(dp[idx][prev]!=null) return dp[idx][prev];
    //     }
    //     int A=0;
    //     int B=0;
    //     if(prev==-1 || arr[idx]-arr[prev]==diff){
    //         A= 1+ Solve(arr,idx+1,diff,idx,dp);
    //     }
    //     B= Solve(arr,idx+1,diff, prev,dp);
    //     if(prev!=-1){
    //         dp[idx][prev]= Math.max(A,B);
    //     }
    //     return Math.max(A,B);
    // }
}