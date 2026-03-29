class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        int n= nums.size();
        long sum=0;
        int si=0;
        int ei=0;
        
        long ans=0;
        while(ei<n){
            int val= nums.get(ei);
            map.put(val,map.getOrDefault(val,0)+1);
            sum+= val;
            if(map.size()>=m && ei-si+1==k){
                ans=Math.max(ans,sum);
            }
            while(ei-si+1 >=k){
                sum-= nums.get(si);
                map.put(nums.get(si), map.get(nums.get(si))-1);
                if(map.get(nums.get(si))==0){
                    map.remove(nums.get(si));
                }
                si++;
            }
            

            ei++;
        }
        return ans;

    }
}