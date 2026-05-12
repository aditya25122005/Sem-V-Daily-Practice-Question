class Solution {
    public int maxBalancedShipments(int[] weight) {
        int max = weight[0];
        int ans=0;
        for(int i=1;i<weight.length;i++){
            if(weight[i]<max){
                ans++;
                if(i+1<weight.length){
                    max = weight[i+1];
                }

            }
            else{
                max = Math.max(max,weight[i]);
            }
        }
        return ans;
    }
}