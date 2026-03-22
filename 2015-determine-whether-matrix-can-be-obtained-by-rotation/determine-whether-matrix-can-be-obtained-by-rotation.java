class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean ans= check1(mat,target) || check2(mat,target) || check3(mat,target) 
       || check4(mat,target);
        return ans;
    }
    public static boolean check1(int [][] mat, int [][] target){
        int n= mat.length;
        int m= mat[0].length;
        int I=0;
        

        for(int i=0;i<n;i++){
            int J=0;
            for(int j=0;j<m;j++){
                if(mat[i][j] != target[I][J]) return false;
                J++;
            }
            I++;
        }
        return true;
    }
    public static boolean check2(int [][] mat, int[][] target){
        int n= mat.length;
        int m= mat[0].length;
        int I=0;

        for(int j=0;j<m;j++){
            int J=0;
            for(int i=n-1;i>=0;i--){
                if(mat[i][j] != target[I][J]) return false;
                J++;
            }
            I++;
        }
        return true;
    }
    public static boolean check3(int [][] mat, int[][] target){
        int n= mat.length;
        int m= mat[0].length;
        int I=0;

        for(int i=n-1;i>=0;i--){
            int J=0;
            for(int j=m-1;j>=0;j--){
                if(mat[i][j] != target[I][J]) return false;
                J++;
            }
            I++;
        }
        return true;
    }

    public static boolean check4(int [][] mat, int[][] target){
        int n= mat.length;
        int m= mat[0].length;
        int I=0;

        for(int j=m-1;j>=0;j--){
            int J=0;
            for(int i=0;i<n;i++){
                if(mat[i][j] != target[I][J]) return false;
                J++;
            }
            I++;
        }
        return true;
    }
}