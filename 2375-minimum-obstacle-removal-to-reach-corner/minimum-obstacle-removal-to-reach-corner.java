class Solution {
    public int minimumObstacles(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int [] r={-1,1,0,0};
        int [] c={0,0,1,-1};


        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2]));
        boolean[][] vis= new boolean[n][m];
        vis[0][0] = true;
        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int [] rm= q.poll();
            int cr= rm[0];
            int cc= rm[1];
            int cost = rm[2];
            if(cr==n-1 && cc== m-1){
                return cost;
            }
            for(int i=0;i<4;i++){
                int nr= cr+ r[i];
                int nc= cc+ c[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m && !vis[nr][nc]){
                    vis[nr][nc]= true;
                    int newCost=cost;
                    if(grid[nr][nc]==1){
                        newCost+=1;
                    }
                    q.add(new int[]{nr,nc,newCost});
                }
            }

        }
        return 0;
    }
}