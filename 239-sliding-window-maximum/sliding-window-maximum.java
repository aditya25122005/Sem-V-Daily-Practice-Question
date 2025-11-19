class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});

            while(pq.peek()[1]<= i-k){
                pq.poll();
            }
            if(pq.size()>=k){
                ans[i-k+1]= pq.peek()[0];
            }
        }
        return ans;
    }
}