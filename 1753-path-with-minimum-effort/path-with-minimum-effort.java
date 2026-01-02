class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int[][] bestFromPoint= new int[n][m];
        for(int []A:bestFromPoint){
            Arrays.fill(A,Integer.MAX_VALUE);
        } 
        PriorityQueue<int[]> q= new PriorityQueue<>((a,b)->a[2]-b[2]);
        int [] x={-1,1,0,0};
        int [] y={0,0,-1,1};
        q.add(new int[]{0,0,0});
        bestFromPoint[0][0]=0;

        while(!q.isEmpty()){
            int[] rm=q.poll();
            int r=rm[0];
            int c=rm[1];
            int effort=rm[2];
            if(r==n-1 && c==m-1){
                return effort;
            }
            for(int i=0;i<x.length;i++){
                int nr=r+x[i];
                int nc=c+y[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m ){
                    
                    int currEffort= Math.max(effort,Math.abs(heights[r][c]-heights[nr][nc]));
                    if(bestFromPoint[nr][nc] > currEffort){
                        bestFromPoint[nr][nc]=currEffort;
                        q.add(new int[]{nr,nc,currEffort});
                    }
                }
            }

        }
        return 0;


    }
}