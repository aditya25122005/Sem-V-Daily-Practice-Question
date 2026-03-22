class Solution {
    public int lengthOfLIS(int[] nums) {
        // // 10, 9,2,5,3,7,101,18
        // 10, 
        // 9,
        // 3,5,7,18 -> Len=4

        // // 0, 1,0,3,2,3
        // 0,1,
        // 0,2,3,3-> Len=4;
        int N= nums.length;
        int [] helper= new int[N];
        helper[0]=nums[0];
        int len=1;
        for(int i=1;i<N;i++){
            if(nums[i]>helper[len-1]){
                helper[len]=nums[i];
                len++;
            }
            else{
                int idx= Search(helper,nums[i],len-1);
                helper[idx] = nums[i];
            }
        }
        return len;

    }
    public static int Search(int [] helper, int item, int hi){
        int lo=0;
        int idx=-1;
        while(lo<=hi){
            int mid= lo+(hi-lo)/2;
            if(helper[mid]<item){
                idx=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return idx+1;
    }
}