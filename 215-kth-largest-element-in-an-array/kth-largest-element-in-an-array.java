class Solution {
    public int findKthLargest(int[] nums, int k) {
        // return find(nums,k);   // O(N log N)
        return Find(nums,k);  //O(N logk)
    }
    public static int find(int[] nums, int k){
        PriorityQueue <Integer> pq= new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int num:nums) pq.add(num);

        for(int i=0;i<k-1;i++){
            pq.poll();
        }
        return pq.poll();

    }
    public static int Find(int [] nums, int k){
        PriorityQueue <Integer> pq= new PriorityQueue<>();
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            if(nums[i]>pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.peek();
    }
}