class NumMatrix {
    int [][] pre;
    int [][] arr;

    public NumMatrix(int[][] matrix) {
        arr = matrix;
        pre = new int[matrix.length][matrix[0].length];

        for(int i=0;i<pre.length;i++){
            int curr=0;
            for(int j=0;j<matrix[0].length;j++){
                curr+= matrix[i][j];
                pre[i][j]=curr;
            }
        }

        for(int j=0;j<pre[0].length;j++){
            int curr=0;
            for(int i=0;i<pre.length;i++){
                curr+= pre[i][j];
                pre[i][j]=curr;
            }
        }


    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = pre[row2][col2];
        if(row1-1>=0){
            res-= pre[row1-1][col2];
        }
        if(col1-1>=0){
            res-= pre[row2][col1-1];
        }
        if(row1-1>=0 && col1-1>=0){
            res+= pre[row1-1][col1-1];
        }
        return res;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */