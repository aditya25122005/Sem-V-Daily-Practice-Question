class Solution {
    public int islandPerimeter(int[][] grid) {
        int n=grid.length;
        int m= grid[0].length;
        p=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    Solve(grid, i,j);
                    return p;
                }
            }
        }
        return p;
    }
    static int p=0;
    public static void Solve(int[][] arr, int cr, int cc){
        if(cr<0 || cc<0 || cr>=arr.length || cc>=arr[0].length ||
        arr[cr][cc]==0 || arr[cr][cc]==2){
            return;
        }
        if(cr==0 ||arr[cr-1][cc]==0){
            p++;
        }
        if(cc==arr[0].length-1 || arr[cr][cc+1]==0){
            p++;
        }
        if(cr==arr.length-1 || arr[cr+1][cc]==0){
            p++;
        }
        if(cc==0 || arr[cr][cc-1]==0){
            p++;
        }
        // Mark curr as visited(2)
        arr[cr][cc] = 2;

        Solve(arr,cr+1,cc);
        Solve(arr,cr-1,cc);
        Solve(arr,cr,cc-1);
        Solve(arr,cr,cc+1);
    }
}