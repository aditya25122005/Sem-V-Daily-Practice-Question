class Solution {
    public int snakesAndLadders(int[][] board) {
        return Solve(board);
    }
    public static int Solve(int[][] board){
        int n= board.length;
        HashSet<Integer> visited= new HashSet<>();
        Queue<Integer> q= new LinkedList<>();
        q.add(1);
        int step=0;
        while(!q.isEmpty()){

            int size=q.size();
            for(int s=0;s<size;s++){
            int x=q.poll();
            // if (x > n*n) continue;
            if(visited.contains(x)){
                continue;
            }
            visited.add(x);
            
            if(x==board.length*board.length){
                return step;
            }
            for(int i=1;i<=6;i++){
                int val=x+i;
                if (val > n*n) continue;
                // find coordinated
                //********************/
                int idx=val-1;
                int row_from_bottom=idx/n; //  11/6 =1
                int r=n-row_from_bottom-1;
                int c;
                if(row_from_bottom %2 ==0){
                    c=idx%n;
                }
                else{
                    c=n-1-(idx%n);
                }
                //*********************/
                    if(board[r][c]==-1){
                        if(!visited.contains(val)){
                        q.add(val);
                        }
                    }
                    else{
                        if(!visited.contains(board[r][c]))
                        q.add(board[r][c]);
                    }
                
            }

        }
        step++;
        }
        return -1;
    }
}