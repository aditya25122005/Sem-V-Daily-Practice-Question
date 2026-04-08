class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long [] arr = new long[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=(long)nums[i];
        }

        int mod= 1000000007;
        for(int i=0;i<queries.length;i++){
            int l= queries[i][0];
            int r= queries[i][1];
            int k= queries[i][2];
            int v= queries[i][3];

            int idx = l;
            while(idx<=r){
                arr[idx]= ((long)arr[idx]*v)%mod;
                idx+= k;
            }

        }
        long xor = 0;
        for(long num: arr){
            xor = (long)(xor^num);
        }
        return (int)(xor);
    }
}