class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int fresh=0;

        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    fresh++;
                }
                else if(grid[i][j]==2){
                    q.add(new int[]{i,j,0});
                }
            }
        }
        if(fresh==0){
            return 0;
        }
        int [][] dir= {{0,1},{0,-1},{1,0},{-1,0}};
        int maxTime=0;
        while(!q.isEmpty()){
            int[] A= q.poll();
            int r=A[0];
            int c=A[1];
            int t=A[2];
            maxTime=Math.max(maxTime,t);

            for(int [] d:dir){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]==1){
                    grid[nr][nc]=2;
                    q.add(new int[]{nr,nc,t+1});
                    fresh--;
                }
            }
        }
        if(fresh>0){
            return -1;
        }
        return maxTime;

    }
}