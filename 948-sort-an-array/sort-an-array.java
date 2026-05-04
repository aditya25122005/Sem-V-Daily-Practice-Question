class Solution {
    public int[] sortArray(int[] nums) {
        int [] res = sort(0,nums.length-1,nums);
        return res;
    }
    public static int [] sort(int lo, int hi, int [] nums){
        if(lo==hi){
            int [] base = new int[1];
            base[0]= nums[lo];
            return base;
        }
        int mid = lo+(hi-lo)/2;
        int [] A = sort(lo,mid, nums);
        int [] B= sort(mid+1,hi,nums);
        return merge(A,B);

    }
    public static int [] merge(int [] A, int [] B){
        int [] res = new int[A.length+B.length];
        int i=0;
        int j=0;
        int k=0;
        while(i<A.length && j<B.length){
            if(A[i]<B[j]){
                res[k++]= A[i++];
            }
            else{
                res[k++]= B[j++];
            }
        }
        while(i<A.length){
            res[k++] = A[i++];
        }
        while(j<B.length){
            res[k++] = B[j++];
        }
        return res;
    }
}