class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n= nums.size();
        int [] ans= new int [n];
        Arrays.fill(ans,-1);
        // a[i] | a[i]+1 = nums[i];

        // 0 1 0

        // 001
        // 010
        // 011

        // 100 //4
        // 101 //5
        // 101 // 5

        for(int i=0;i<n;i++){
            int val= nums.get(i);
            for(int j=1;j<=1000;j++){
                if((j | (j+1)) == val){
                    ans[i] = j;
                    break;
                }
            }
        }
        return ans;


    }
}