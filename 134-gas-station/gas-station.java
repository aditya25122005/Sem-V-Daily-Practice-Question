class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int balance=0;
        for(int i=0;i<gas.length;i++){
            balance += gas[i]-cost[i];
        }
        if(balance<0) return -1;
        int curr=0;
        int ans=0;
        for(int i=0;i<gas.length;i++){
            curr+= gas[i]-cost[i];
            if(curr<0){
                curr=0;
                ans=i+1;
            }
        }
        return ans;
    }

}