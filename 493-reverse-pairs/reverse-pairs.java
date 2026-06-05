class Solution {
    public int reversePairs(int[] nums) {
        cnt = 0;
        int [] res = sort(nums,0,nums.length-1);
        return cnt;
    }
    int cnt;
    public int [] sort(int [] nums, int lo, int hi){
        if(lo==hi){
            int [] base = new int[1];
            base[0] = nums[lo];
            return base;
        }
        int mid = lo+(hi-lo)/2;
        int [] A = sort(nums, lo,mid);
        int [] B = sort(nums, mid+1,hi);
        int j=0;
        for(int i=0;i<A.length;i++){
            while(j<B.length && (long)A[i]> (long)2*B[j]){
                j++;
            }
            cnt +=j;
        }
        return Merge(A,B);
    }
    public int[] Merge(int [] A, int[]B){
        int [] ans = new int[A.length+B.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<A.length && j<B.length){
            if(A[i]<=B[j]){
                ans[k++] = A[i++];
            }
            else{
                ans[k++]= B[j++];
            }
        }
        while(i<A.length){
            ans[k++] = A[i++];
        }
        while(j<B.length){
            ans[k++] = B[j++];
        }
        return ans;
    }
}