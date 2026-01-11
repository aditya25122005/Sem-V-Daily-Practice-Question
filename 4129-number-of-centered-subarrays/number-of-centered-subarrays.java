class Solution {
    public int centeredSubarrays(int[] nums) {
        int count=0;
        int [] pre= new int[nums.length];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                int curr=0;
                HashSet<Integer> hh= new HashSet<>();
                if(i==0) curr= pre[j];
                else{
                    curr= pre[j]-pre[i-1];
                }
             

                for(int k=i;k<=j;k++){
                    if(nums[k]==curr){
                        count++;
                        break;
                    }
                }
            }       
        }
        return count;
    }
}