class Solution {
    public int minimumCost(int[] cost) {

        Arrays.sort(cost);
        int n= cost.length;
        int total=0;
        int i=n-1;
        for(i=n-1;i>=1;i-=3){
            total+= cost[i];
            total+= cost[i-1];
        }
        while(i>=0){
            total+=cost[i];
            i--;
        }
        return total;
    }
}