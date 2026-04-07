class Solution {
    public int minSubarray(int[] nums, int p) {
        long [] pre  = new long[nums.length+1];
        for(int i=1;i<pre.length;i++){
            pre[i]= pre[i-1]+ nums[i-1];
        }
        long total = pre[pre.length-1];
        long rem = total%p;
        if(rem==0) return 0;
        int rm = Integer.MAX_VALUE;
        
        HashMap<Long,Integer> map= new HashMap<>();
        map.put(0L,-1);
        for(int i=0;i<pre.length;i++){
            long curr = pre[i]%p;
            if(map.containsKey((curr-rem+p)%p)){
                rm = Math.min(rm, i-map.get((curr-rem+p)%p));
            }
            map.put(curr,i);
        }
        return rm==Integer.MAX_VALUE || rm==nums.length? -1 : rm;

    }
}