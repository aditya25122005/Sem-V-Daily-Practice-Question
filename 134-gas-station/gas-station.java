class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length;
        int total=0;
        for(int i=0;i<n;i++){
            total+=gas[i]-cost[i];
        }
        if(total<0) return -1;
        int curr=0;
        int idx=0;
        for(int i=0;i<n;i++){
            curr+=gas[i]-cost[i];
            if(curr<0){
                curr=0;
                idx=i+1;
            }
        }
        return idx;
        
    }
}