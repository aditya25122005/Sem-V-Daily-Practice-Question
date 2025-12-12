class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        Solve(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public static void Solve(int[][] arr, int cr, int cc, int color, int startColor){

        Queue<int[]> q= new LinkedList<>();
        arr[cr][cc]=color;
        q.add(new int[]{cr,cc});
        int [][]dir={{-1,0},{1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] P= q.poll();
            int r=P[0];
            int c=P[1];
            for(int[] d:dir){
                int nr= r+d[0];
                int nc= c+d[1];
                if(nr>=0 && nr<arr.length && nc>=0 && nc<arr[0].length && arr[nr][nc]==startColor){
                    arr[nr][nc]=color;
                    q.add(new int[]{nr,nc});
                }   
            }



        }
      

    }
}