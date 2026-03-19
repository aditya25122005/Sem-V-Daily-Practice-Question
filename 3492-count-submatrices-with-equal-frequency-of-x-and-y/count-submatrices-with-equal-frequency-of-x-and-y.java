class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        int [][][] arr= new int[n][m][2];
        for(int i=0;i<n;i++){
            int currX=0;
            int currY=0;
            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){
                    currX++; 
                }
                else if(grid[i][j]=='Y'){
                    currY++;
                }
                arr[i][j][1] =currY;
                arr[i][j][0] = currX;
            }
        }
        int count=0;
        for(int j=0;j<m;j++){
            int currX=0;
            int currY=0;
            for(int i=0;i<n;i++){
                currX+= arr[i][j][0];
                currY+= arr[i][j][1];

                arr[i][j][0] = currX;
                arr[i][j][1] = currY;

                if(currX==currY && arr[i][j][0]!=0){
                    count++;
                }
            }
        }
        return count;
    }
}