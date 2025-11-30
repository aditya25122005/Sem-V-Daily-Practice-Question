class Solution {
    public int countElements(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        List<Integer> ll= new ArrayList<>(map.keySet());
        Collections.sort(ll);
        long greater=0;
      int ans=0;
        for(int i=ll.size()-1;i>=0;i--){
            int val= ll.get(i);
            int count= map.get(val);
            if(greater>=k){
                ans+=count;
            }
            greater+=count;
        }
        return ans;
    }
}