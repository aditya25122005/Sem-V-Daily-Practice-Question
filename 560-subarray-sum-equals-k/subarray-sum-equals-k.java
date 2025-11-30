class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pre= new int[nums.length];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        int c=0;
          // 1  2  3
          for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int curr=0;
                if(i!=0){
                curr= pre[j]-pre[i-1];
                }
                else{
                    curr=pre[j];
                }
                if(curr==k)c++;
            }
          }
          return c;


     }
}