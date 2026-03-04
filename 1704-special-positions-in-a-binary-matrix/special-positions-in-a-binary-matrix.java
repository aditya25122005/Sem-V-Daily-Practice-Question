class Solution {
    public int numSpecial(int[][] mat) {
        int c=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1 && isOk(mat,i,j)){
                    c++;
                }
            }
        }
        return c;
        // int [] row= new int[mat.length];
        // int [] col= new int[mat[0].length];
        // for(int i=0;i<mat.length;i++){
        //     int sum=0;
        //     for(int j=0;j<mat[0].length;j++){
        //         if(mat[i][j]==1){
        //             sum++;
        //         }
        //     }
        //     row[i]=sum;
        // }

        // for(int i=0;i<mat.length;i++){
        //     int sum=0;
        //     for(int j=0;j<mat[0].length;j++){
        //         if(mat[j][i]==1){
        //             sum++;
        //         }
        //     }
        //     col[i]=sum;
        // }
        // int c=0;
        // for(int i=0;i<Math.min(mat.length,mat[0].length);i++){
        //     if(row[i]==1 && col[i]==1){
        //         c++;
        //     }
        // }
        // return c;

    }
    public static boolean isOk(int[][] arr, int r, int c){
        int count=0;
        for(int col=0;col<arr[0].length;col++){
            if(arr[r][col]==1){
                count++;
                if(count>1) return false;
            }
        }
        count=0;
        for(int row=0;row<arr.length;row++){
            if(arr[row][c]==1){
                count++;
                if(count>1) return false;
            }
        }
        return true;
    }
}