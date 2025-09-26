class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        
        int[] ans = Solve(nums, k);
        return ans;
    }
    public static int[] Solve(int [] nums, int k){
        int n=nums.length;
        int[] ans= new int[n-k+1];

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->b[0]-a[0]); // max ele first
        for(int i=0;i<n;i++){
            pq.add(new int[]{nums[i] , i});

            // Remove from window
            while(pq.peek()[1] <= i-k){
                pq.poll();
            }
            // We we have a appropriate window add it in ans
            if(pq.size() >= k){
                ans[i-k+1] = pq.peek()[0];
            }
        }
        return ans;
    }
    //TLE \U0001f641\U0001f613
    // public static void Solve(int[] nums, int k, int [] ans){
    //     int n=nums.length;
    //     int currMax=Integer.MIN_VALUE;
    //     int idx=0;
    //     for(int i=0;i<k;i++){
    //         currMax=Math.max(currMax, nums[i]);
    //     }
    //     ans[idx++]=currMax;
    //     for(int i=k;i<n;i++){
    //         ans[idx++]=findMax(nums,idx-1 ,i);
    //     }


    // }
    // public static int findMax(int[] nums,int si,int ei){
    //     int max=Integer.MIN_VALUE;
    //     for(int i=si;i<=ei;i++){
    //         max=Math.max(max,nums[i]);
    //     }
    //     return max;
    // }
}