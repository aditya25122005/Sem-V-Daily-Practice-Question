class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ll= new ArrayList<>();
        int n= matrix.length;
        int m= matrix[0].length;
        int total = n*m;
        int curr=0;
        int sr=0;
        int sc=0;
        int er=n-1;
        int ec=m-1;



        while(curr<total){
            
            for(int c=sc;c<= ec;c++){
                ll.add(matrix[sr][c]);
                curr++;
                if(curr==total){
                    break;
                }
            }
            if(curr==total){
                    break;
            }
            sr++;
            for(int r=sr;r<=er;r++){
                ll.add(matrix[r][ec]);
                curr++;
                if(curr==total){
                    break;
                }
            }
            if(curr==total){
                    break;
            }
            ec--;

            for(int c=ec;c>=sc;c--){
                ll.add(matrix[er][c]);
                curr++;
                if(curr==total){
                    break;
                }
            }
            if(curr==total){
                    break;
            }
            er--;

            for(int r=er;r>=sr;r--){
                ll.add(matrix[r][sc]);
                curr++;
                if(curr==total){
                    break;
                }
            }
            if(curr==total){
                    break;
            }
            sc++;
            if(curr==total){
                break;
            }
        }
        return ll;
    }
   
}