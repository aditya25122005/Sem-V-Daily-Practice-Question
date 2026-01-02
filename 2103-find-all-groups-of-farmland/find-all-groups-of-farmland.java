class Solution {
    public int[][] findFarmland(int[][] land) {
        List<int[]> ll= new ArrayList<>();
        
     for(int i=0;i<land.length;i++){
        for(int j=0;j<land[0].length;j++){
            if(land[i][j]==1){
                maxr=i;
                maxc=j;
                Solve(i,j,land);
                ll.add(new int[]{i,j,maxr,maxc});
            }
        }
     }   
     int [][] ans= new int[ll.size()][4];
     int idx=0;
     for(int[]A:ll){
        ans[idx++]=A;
     }
     return ans;
    }
    static int maxr;
    static int maxc;
    public static void Solve(int cr, int cc,int[][]grid){
        if(cr>=grid.length || cc>=grid[0].length || grid[cr][cc]==0){
            return;
        }
        grid[cr][cc]=0;
        maxr=Math.max(maxr,cr);
        maxc=Math.max(maxc,cc);

        Solve(cr+1,cc,grid);
        Solve(cr,cc+1,grid);
    }
}