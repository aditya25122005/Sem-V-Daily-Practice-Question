class Solution {
    public int minSubarray(int[] nums, int p) {
        long[] pre= new long[nums.length];
        pre[0]= nums[0];
        // prefix sum 3 4 8 10 %p -> 3 4 2 4
        for(int i=1;i<nums.length;i++){
            pre[i]=(long)(pre[i-1]+ nums[i]);
        }
        long sum=0;
        for(int num:nums){
            sum+= (long)num;
        }
        if(sum%p==0){
            return 0;
        }
        int req= (int)(sum%p);
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<pre.length;i++){
            int cmod=(int)(pre[i]%p);
            int needed= (cmod-req+p)%p;
            if(map.containsKey(needed)){
                ans=Math.min(ans,i-map.get(needed));
            }
            map.put(cmod,i);
            
        }
        return ans>=nums.length? -1:ans;
       
    }
}