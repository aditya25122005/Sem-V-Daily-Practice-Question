class Solution {
    public int maximumWealth(int[][] accounts) {
        int max=Integer.MIN_VALUE;
        for(int []a:accounts){
            int sum=0;
            for(int r:a) sum+=r;
            max=Math.max(max,sum);
        }
        return max;
    }
}