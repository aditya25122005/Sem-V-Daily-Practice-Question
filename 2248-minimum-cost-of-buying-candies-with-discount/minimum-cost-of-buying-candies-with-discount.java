class Solution {
    public int minimumCost(int[] cost) {
        // 2,2,5,6,7,9
        // 1,3,3,3

        Arrays.sort(cost);
        int n= cost.length;
        int cover=n-1;
        int total=0;
        int i=n-1;
        for(i=n-1;i>=1;i-=3){
            total+= cost[i];
            total+= cost[i-1];
            cover=i-2;
        }
        while(i>=0){
            total+=cost[i];
            i--;
        }
        return total;
       

    }
}