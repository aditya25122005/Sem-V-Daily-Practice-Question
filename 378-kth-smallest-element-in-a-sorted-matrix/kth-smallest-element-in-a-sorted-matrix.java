class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n= matrix.length;
        int m= matrix[0].length;
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(int r=0;r<matrix.length;r++){
            pq.add(new Pair(r,0,matrix[r][0]));
        }
        while(k>1){
            Pair rm= pq.poll();
            int row= rm.r;
            int col= rm.c;
            int v= rm.val;
            if(col+1<m){
                pq.add(new Pair(row,col+1,matrix[row][col+1]));
            }
            k--;
        }
        return pq.poll().val;
    }   
    class Pair{
        int r;
        int c;
        int val;

        public Pair(int r, int c,int val){
            this.r=r;
            this.c=c;
            this.val=val;
        }
    }
}