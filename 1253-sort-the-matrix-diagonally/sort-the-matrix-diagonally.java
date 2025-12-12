class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        for(int startRow=0;startRow<m;startRow++){
            PriorityQueue<Integer> pq= new PriorityQueue<>();
            int r= startRow;
            int c=0;
            while(r<m && c<n){
                pq.add(mat[r][c]);
                r++;
                c++;
            }
            r=startRow;
            c=0;
            while(r<m && c<n){
                mat[r][c]= pq.poll();
                r++;
                c++;
            }
        }
        for(int startCol=1;startCol<n;startCol++){
            PriorityQueue<Integer> pq= new PriorityQueue<>();
            int r=0;
            int c=startCol;
            while(r<m && c<n){
                pq.add(mat[r][c]);
                r++;
                c++;
            }
            r=0;
            c=startCol;
            while(r<m && c<n){
                mat[r][c]=pq.poll();
                r++;
                c++;
            }
        }
        return mat;
    }
}