class Solution {
    public boolean isValidSudoku(char[][] board) {
        return isValid(board);
    }
    public static  boolean isValid(char[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char ch= board[i][j];
                if(ch!='.'){
                    board[i][j]='.';
                    if(!isPresent(board,ch,i,j)){
                        return false;
                    }
                    board[i][j]=ch;
                }
            }
        }
        return true;
    }
    public static boolean isPresent(char[][]arr,char ch,int r, int c){
        // check col
        for(int i=0;i<arr.length;i++){
            if(arr[i][c]==ch){
                return false;
            }
            
        }
        // check row
        for(int i=0;i<arr.length;i++){
            if(arr[r][i]==ch){
                return false;
            }
        }
        // check box
        int row=r- r%3;
        int col= c- c%3;
        for(int i=row;i<row+3;i++){
            for(int j=col;j<col+3;j++){
                if(arr[i][j]==ch){
                    return false;
                }
            }
        }
        return true;

    }
}