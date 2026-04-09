class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n= nums.length;
        int [] ans= new int[n-k+1];
        int j=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(b[0],a[0]));
        for(int i=0;i<nums.length;i++){
            pq.add(new int[]{nums[i],i});

            // agr peek wala element out of range hai then poll it
            while(pq.peek()[1]<= i-k){
                pq.poll();
            }
            if(i>=k-1){
                ans[j++] = pq.peek()[0];
            }
            
        }
        return ans;
    }
}