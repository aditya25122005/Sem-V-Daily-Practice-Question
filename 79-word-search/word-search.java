class Solution {
    public boolean exist(char[][] board, String word) {
        boolean hai= false;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    hai=Dekho(board, word, i, j,0);
                    if(hai) return true;
                }
            }
        }
        return hai;
    }
    public static boolean Dekho(char[][] board, String word,int cr, int cc, int idx){
        if(idx==word.length()){
            return true;
        }
        if(cc<0 || cc>=board[0].length || cr<0 || cr>=board.length||board[cr][cc] != word.charAt(idx)){
            return false;
        }
        board[cr][cc]='*';

        if(Dekho(board,word,cr+1,cc,idx+1)) return true;
        if(Dekho(board,word,cr-1,cc,idx+1)) return true;
        if(Dekho(board,word,cr,cc+1,idx+1)) return true;
        if(Dekho(board,word,cr,cc-1,idx+1)) return true;
        

        board[cr][cc]=word.charAt(idx);
        return false;


    }
    
}