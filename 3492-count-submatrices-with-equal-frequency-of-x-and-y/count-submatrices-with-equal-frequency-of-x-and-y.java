class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        int [][][] arr= new int[n][m][2];

        int [][] xarr = new int [n][m];
        for(int i=0;i<n;i++){
            int currX=0;

            for(int j=0;j<m;j++){
                if(grid[i][j]=='X'){
                    currX++;
                }
                xarr[i][j]=currX;
            }
        }


        for(int j=0;j<m;j++){
            int currX=0;
            for(int i=0;i<n;i++){
                currX+= xarr[i][j];
                xarr[i][j] = currX;
            }
        }
        
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
        // (1,0) --> 1,1 --> 1,1
        // (0,1) --> (0,1) --> (0,1)

        for(int j=0;j<m;j++){
            int currX=0;
            int currY=0;

            for(int i=0;i<n;i++){
                currX+= arr[i][j][0];
                currY+= arr[i][j][1];

                arr[i][j][0] = currX;
                arr[i][j][1] = currY;
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int x = arr[i][j][0];
                int y = arr[i][j][1];

                if(x==y && xarr[i][j]!=0){
                    count++;
                }
            }
        }
        return count;



    }
    
}