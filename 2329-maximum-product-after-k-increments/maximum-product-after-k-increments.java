class Solution {
    public int maximumProduct(int[] nums, int k) {
        long prod=1;
        int mod=1000000007;
        Arrays.sort(nums);
        int n=nums.length;
        PriorityQueue<Integer> pq= new PriorityQueue<>(n);
        for(int num:nums){
            pq.add(num);
        }
        for(int i=0;i<k;i++){
            pq.add(pq.poll()+1);
        }
        long ans=1;
        while(!pq.isEmpty()){
            ans=(ans* pq.poll())%mod;
        }
        return (int)ans;

    }
}