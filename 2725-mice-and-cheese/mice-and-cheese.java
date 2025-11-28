class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n= reward1.length;
        int total=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            total+= reward2[i];
            pq.add(reward1[i]-reward2[i]);
        }
        for(int i=0;i<k;i++){
            total+= pq.poll();
        }
        return total;
        // int n= reward1.length;
        // int total=0;
        // PriorityQueue<int[]> pq= new PriorityQueue<>( (a,b)-> a[1]-b[1] );
        // PriorityQueue<int[]> pq2= new PriorityQueue<>((a,b) -> b[0]-a[0]);
        // for(int i=0;i<n;i++){
        //     total+=reward2[i];
        //     pq.add(new int[]{reward1[i], reward2[i]});
        //     pq2.add(new int[]{reward1[i], reward2[i]});
        // }
        // int ans1= total;
        // for(int i=0;i<k;i++){
        //     int [] rm= pq.poll();
        //     ans1-= rm[1];
        //     ans1+= rm[0];
        // }
        // int ans2=total;
        // for(int i=0;i<k;i++){
        //     int [] rm = pq2.poll();
        //     ans2+= rm[0];
        //     ans2-= rm[1];
        // }
        // return Math.max(ans1,ans2);
    }
}