class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum =0;
        for(int i=0;i<k;i++)
        {   
            sum+= nums[i];
        }
        double ansAvg = (double)sum/k;
        double ans = sum;
        for(int i=k;i<nums.length;i++){
            sum+= nums[i];
            sum-= nums[i-k];
            ansAvg= Math.max(ansAvg, (double)sum/k);
        }
        return ansAvg;
    }
}