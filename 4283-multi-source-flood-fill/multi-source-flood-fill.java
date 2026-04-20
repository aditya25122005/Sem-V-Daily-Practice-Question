class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int [][] grid = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        Arrays.sort(sources,(a,b)->Integer.compare(b[2],a[2]));
        for(int [] E : sources){
            q.add(new int[]{E[0],E[1],E[2]});
            grid[E[0]][E[1]] = E[2];
        }
        int [] R = {-1,1,0,0};
        int [] C = {0,0,1,-1};

        while(!q.isEmpty()){
            int size = q.size();

            for(int s=0;s<size;s++){
                int [] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int color = curr[2];

                for(int i=0;i<4;i++){
                    int nr = r+R[i];
                    int nc = c+C[i];
                    if(nr<n && nc<m && nr>=0 && nc>=0 && grid[nr][nc]==0){
                        grid[nr][nc] = color;
                        q.add(new int[]{nr,nc,color});
                    }
                }

            }
        }
        return grid;
    }
}