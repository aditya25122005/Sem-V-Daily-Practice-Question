class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ll = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.sum,b.sum));
        pq.add(new Pair(0,0,nums1[0]+nums2[0]));
        HashSet<String> vis = new HashSet<>();
        vis.add(0+"-"+0);
        while(!pq.isEmpty() && k>0){
            Pair rm = pq.poll();
            int i = rm.i;
            int j = rm.j;
            int s = rm.sum;
            List<Integer> inner = new ArrayList<>();
            inner.add(nums1[i]);
            inner.add(nums2[j]);

            

            ll.add(new ArrayList<>(inner));
            // i, j+1;
            if(j+1<nums2.length){
                String c = i+"-"+(j+1);
                if(!vis.contains(c)){
                    vis.add(c);
                    pq.add(new Pair(i,j+1,nums1[i]+nums2[j+1]));
                }
                
            }
            // i+1,j
            if(i+1<nums1.length){
                String c = (i+1)+"-"+(j);
                if(!vis.contains(c)){
                    vis.add(c);
                    pq.add(new Pair(i+1,j,nums1[i+1]+nums2[j]));
                }
                
            }
            // i+1 , j+1
            if(i+1<nums1.length && j+1<nums2.length){
                String c = (i+1)+"-"+(j+1);
                if(!vis.contains(c)){
                    vis.add(c);
                    pq.add(new Pair(i+1,j+1, nums1[i+1]+nums2[j+1]));
                }
            }
            k--;

        }
        return ll;
    }
    static  class Pair{
        int i;
        int j;
        int sum;
        public Pair(int i, int j, int sum){
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }
}