class Solution {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int num= nums[i];
            int r= rev(num);
            if(map.containsKey(r) && map.get(r)>i){
                ans=Math.min(ans,map.get(r)-i);
            }
            else{
               continue;
            }

        }
        return ans==Integer.MAX_VALUE? -1:ans;
    }
    public static int rev(int x){
        int ans=0;
        while(x!=0){
            int r= x%10;
            ans= ans*10+r;
            x/=10;
        }
        return ans;
    }
}