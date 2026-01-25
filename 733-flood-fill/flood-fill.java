class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n= image.length;
        int m= image[0].length;
        Queue<int[]> q= new LinkedList<>();

        boolean [][] visited = new boolean[n][m];

        int [] r = {-1,1,0,0};
        int [] c = {0,0,1,-1};
        

        q.add(new int[]{sr,sc,image[sr][sc]});
            while(!q.isEmpty()){
                int [] A= q.poll();
                int cr= A[0];
                int cc= A[1];
                int old= A[2];
                visited[cr][cc]=true;
             

                for(int k=0;k<r.length;k++){
                    int nr= cr+r[k];
                    int nc= cc+c[k];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && image[nr][nc]==old && !visited[nr][nc]){
                        q.add(new int[]{nr,nc,old});
                        visited[nr][nc] = true;
                        image[nr][nc]=color;
                    }
                }


            }
        image[sr][sc]=color;
        return image;
    }
}