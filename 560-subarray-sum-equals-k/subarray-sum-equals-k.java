class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int[] pre= new int[nums.length];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=pre[i-1]+nums[i];
        }
        // Pre => [1,2,3] k=2;
        int c=0;
        for(int i=0;i<nums.length;i++){
          // if pre[i]-pre[j]==k
          // check if we have seen -> pre[i]-k * how many times

          if(map.containsKey(pre[i]-k)){
            c+= map.get(pre[i]-k);
          }
          
          map.put(pre[i],map.getOrDefault(pre[i],0)+1);
    
        }
        return c;
    }
}