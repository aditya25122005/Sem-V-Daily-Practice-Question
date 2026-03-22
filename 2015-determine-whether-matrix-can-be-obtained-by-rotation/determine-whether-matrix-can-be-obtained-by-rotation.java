class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        boolean ans= check1(mat,target) || check2(mat,target) || check3(mat,target) || check4(mat,target)
       || check6(mat,target);
        return ans;
    }
    // 0 1 0 0
    // 0 0 0 1
    // 0 1 0 0
    // 0 1 1 1

    // ->
    // 0 0 0 0
    // 1 1 0 1
    // 1 0 0 0
    // 1 0 1 0

    // ->

    // 1 1 1 0
    // 0 0 1 0
    // 1 0 0 0
    // 0 0 1 0

    // ->
    // 0 1 0 1
    // 0 0 0 1
    // 1 0 1 1
    // 0 0 0 0


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
            for(int i=n-1;i>=0;i--){
                if(mat[i][j] != target[I][J]) return false;
                J++;
            }
            I++;
        }
        return true;
    }
    // check 5
    
     public static boolean check5(int [][] mat, int[][] target){
        int n= mat.length;
        int m= mat[0].length;
        int I=0;

        for(int i=0;i<n;i++){
            int J=0;
            for(int j=m-1;j>=0;j--){
                if(mat[i][j] != target[I][J]) return false;
                J++;
            }
            I++;
        }
        return true;
    }

    public static boolean check6(int [][] mat, int[][] target){
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