class Solution {
    public boolean canReach(int[] arr, int start) {
        boolean [] vis = new boolean[arr.length];
        return Solve(arr,start,vis);
    }
    public static boolean Solve(int [] arr, int idx,boolean [] vis){
        if(idx<0 || idx>=arr.length || vis[idx]){
            return false;
        }
        if(arr[idx]==0){
            return true;
        }
        vis[idx] = true;
        boolean res = false;
        res = res || Solve(arr,idx+arr[idx],vis);
        res = res || Solve(arr,idx-arr[idx],vis);
        vis[idx] = false;
        return res;
    }
}