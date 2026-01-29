class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int Count=0;

        for(int i=0;i<coins.length;i++){
            if(coins[i]> Count+1) break;
            Count+= coins[i];
        }
        return Count+1;

    }
}