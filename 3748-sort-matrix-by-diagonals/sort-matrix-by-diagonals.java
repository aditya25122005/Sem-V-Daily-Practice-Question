class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n= grid.length;
        for(int startRow=0;startRow<n;startRow++){
            PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
            int r=startRow;
            int c=0;
            while(r<n && c<n){
                pq.add(grid[r][c]);
                r++;
                c++;
            }
            r=startRow;
            c=0;
            while(r<n && c<n){
                grid[r][c]= pq.poll();
                r++;
                c++;
            }

        }
        for(int startCol=1;startCol<n;startCol++){
            int r=0;
            int c=startCol;
            PriorityQueue<Integer> pq= new PriorityQueue<>();
            while(r<n && c<n){
                pq.add(grid[r][c]);
                r++;
                c++;
            }
            r=0;
            c=startCol;
            while(r<n && c<n){
                grid[r][c]=pq.poll();
                r++;
                c++;
            }

        }
        return grid;
    }
}