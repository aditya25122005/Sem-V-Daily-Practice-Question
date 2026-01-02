class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) return false;
        // return isValid(0,0,0,grid);
        int n= grid.length;
        HashMap<Integer,int[]> map= new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                int ele= grid[i][j];
                map.put(ele, new int[]{i,j});
            }
        }
        for(int i=0;i<n*n -1;i++){
            int [] curr= map.get(i);
            int cr=curr[0];
            int cc=curr[1];

            int [] next= map.get(i+1);
            int nr= next[0];
            int nc= next[1];

            if((Math.abs(cr-nr)==2 && Math.abs(cc-nc)==1)  || (Math.abs(cr-nr)==1 && Math.abs(cc-nc)==2)){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    // public static boolean isValid(int cr, int cc, int target, int[][] grid){
    //     int n=grid.length;
    //     if(target==n*n -1){
    //         return true;
    //     }
    //     int [] x={-2,-2,-1,1,2,2,1,-1};
    //     int [] y={-1,1,2,2,1,-1,-2,-2};
    //     for(int i=0;i<x.length;i++){
    //         int nr=cr+x[i];
    //         int nc=cc+y[i];
    //         if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==target+1){
    //             return isValid(nr,nc,target+1,grid);
    //         }
    //     }
    //     return false;
    // }
}