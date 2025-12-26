class Solution {
    public void gameOfLife(int[][] board) {
        int n= board.length;
        int m= board[0].length;
        int [][] grid= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int dead=countDead(board,i,j);
                int live=countLive(board,i,j);
                if(board[i][j]==0){
                    if(live==3){
                        grid[i][j]=1;
                    }
                }
                else{
                    if(live<2) grid[i][j]=0;
                    else if(live==2 || live==3) grid[i][j]=1;
                    else if(live>3) grid[i][j]=0;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=grid[i][j];
            }
        }
       
        
    }
     public static int countDead(int[][]arr, int cr, int cc){
            int dead=0;
            if(cr!=0 && arr[cr-1][cc]==0){
                dead++;
            }
            if(cr!=arr.length-1 && arr[cr+1][cc]==0){
                dead++;
            }
            if(cc!=0 && arr[cr][cc-1]==0){
                dead++;
            }
            if(cc!=arr[0].length-1 && arr[cr][cc+1]==0){
                dead++;
            }
            if(cr!=0 && cc!=0 && arr[cr-1][cc-1]==0){
                dead++;
            }
            if(cr!=arr.length-1 && cc!=0 && arr[cr+1][cc-1]==0){
                dead++;
            }
            if(cr!=0 && cc!=arr[0].length-1 && arr[cr-1][cc+1]==0){
                dead++;
            }
            if(cr!=arr.length-1 && cc!=arr[0].length-1 && arr[cr+1][cc+1]==0){
                dead++;
            }
            return dead;
        }
    public static int countLive(int [][]arr, int cr, int cc){
             int dead=0;
            if(cr!=0 && arr[cr-1][cc]==1){
                dead++;
            }
            if(cr!=arr.length-1 && arr[cr+1][cc]==1){
                dead++;
            }
            if(cc!=0 && arr[cr][cc-1]==1){
                dead++;
            }
            if(cc!=arr[0].length-1 && arr[cr][cc+1]==1){
                dead++;
            }
            if(cr!=0 && cc!=0 && arr[cr-1][cc-1]==1){
                dead++;
            }
            if(cr!=arr.length-1 && cc!=0 && arr[cr+1][cc-1]==1){
                dead++;
            }
            if(cr!=0 && cc!=arr[0].length-1 && arr[cr-1][cc+1]==1){
                dead++;
            }
            if(cr!=arr.length-1 && cc!=arr[0].length-1 && arr[cr+1][cc+1]==1){
                dead++;
            }
            return dead;
        }
}