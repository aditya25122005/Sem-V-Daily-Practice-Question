class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pre= new int[nums.length+1];
        pre[0]=0;
        for(int i=1;i<=nums.length;i++){
            pre[i]=pre[i-1]+nums[i-1];
        }
        int c=0;
          // 1  2  3
          for(int i=0;i<pre.length;i++){
            for(int j=i+1;j<pre.length;j++){
                if(pre[j]-pre[i]==k) c++;
                
            }
          }
          return c;


     }
}