class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count=0;
        for(int i=0;i+3<=grid.length;i++){
            for(int j=0;j+3<=grid[0].length;j++){
                if(isMagicSq(i,j,grid)) count++;
            }
        }
        return count;
    }
    public static boolean isMagicSq(int r, int c, int [][]arr){
        int pre=0;
        int d1=0;
        HashSet<Integer> hh= new HashSet<>();
        for(int i=r;i<r+3;i++){
            int curr=0;
            for(int j=c;j<c+3;j++){
                if(arr[i][j]>9 || arr[i][j]<=0) return false;
                hh.add(arr[i][j]);
                curr+=arr[i][j];
                if(i-r==j-c){
                    d1+=arr[i][j];
                }
            }
            
            if(pre==0){
                pre=curr;
            }
            else{
                if(pre!=curr) return false;
            }
            
        }
        if(hh.size()!=9) return false;
        if(d1!=pre) return false;
        int d2=0;
        for(int i=r;i<r+3;i++){
            int col=c+(r+2-i);
            d2+= arr[i][col];
        }
        if(d2!=d1 || d2!=pre) return false;


        for(int j=c;j<c+3;j++){
            int curr=0;
            for(int i=r;i<r+3;i++){
                curr+= arr[i][j];
            }
            if(curr!=pre) return false;
        }
        return true;
    }
}