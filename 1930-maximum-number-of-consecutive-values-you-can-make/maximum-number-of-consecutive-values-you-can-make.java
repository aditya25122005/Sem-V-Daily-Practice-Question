class Solution {
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int count=0;
        for(int i=0;i<coins.length;i++){
            if(count+1 < coins[i]) break;
            count+=coins[i];
        }
        return count+1;


    }
}
// 1 1 3 4 10