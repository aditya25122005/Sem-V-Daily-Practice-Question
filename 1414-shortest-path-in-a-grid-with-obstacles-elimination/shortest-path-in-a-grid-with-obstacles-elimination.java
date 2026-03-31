class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n= grid.length;
        int m= grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        boolean[][][] vis= new boolean[n][m][k+1];
        q.add(new int[]{0,0,k,0});
        vis[0][0][k] = true;
        int step=Integer.MAX_VALUE;
        int curr=0;
        int [] r= {-1,1,0,0};
        int [] c= {0,0,1,-1};
        while(!q.isEmpty()){
            int []rm= q.poll();
            
            int cr= rm[0];
            int cc= rm[1];
            int currk= rm[2];
            int currStep= rm[3];

            if(cr==n-1 && cc==m-1){
                return currStep;
            }

            for(int i=0;i<r.length;i++){
                int nr= cr+ r[i];
                int nc= cc+ c[i];
                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    int newK= currk-grid[nr][nc]; // agr 0 hai to same nahi to -1
                    if(newK>=0 && !vis[nr][nc][newK]){
                        vis[nr][nc][newK]= true;
                        q.add(new int[]{nr,nc,newK,currStep+1});
                    }
                }
            }

        }
        return -1;
    }
}