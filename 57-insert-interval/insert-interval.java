class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ll = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            ll.add(intervals[i]);
        }
        ll.add(newInterval);

        Collections.sort(ll,(a,b)->Integer.compare(a[0],b[0]));
        int start = ll.get(0)[0];
        int end = ll.get(0)[1];

        List<int[]> res = new ArrayList<>();
      

        for(int i=1;i<ll.size();i++){
            if(ll.get(i)[0]<= end){
                end = Math.max(end, ll.get(i)[1]);
            }
            else{
                res.add(new int[]{start, end});
                start = ll.get(i)[0];
                end = ll.get(i)[1];
            }
        }
        res.add(new int[]{start,end});
        int [][] ans = new int[res.size()][2];
        for(int i=0;i<res.size();i++){
            ans[i]=res.get(i);
        }
        return ans;

        
    }
}