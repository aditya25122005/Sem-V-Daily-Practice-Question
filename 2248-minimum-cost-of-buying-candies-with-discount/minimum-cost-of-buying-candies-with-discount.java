class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int i = cost.length-1;
        int c = 0;
        int ans = 0;
        while(i>=0){
            if(c==2) {
                i--;
                c=0;
                continue;
            }
            ans+= cost[i];
            i--;
            c++;
        }
        return ans;
    }
}