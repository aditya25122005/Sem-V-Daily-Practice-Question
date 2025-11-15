class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        BFS(image,sr,sc,color);
        return image;
        
    }
    public static void BFS(int[][] tasveer, int sr, int sc, int NayaColor){
        int n=tasveer.length;
        int m=tasveer[0].length;
        int old=tasveer[sr][sc];
        Queue<int[]> q= new LinkedList<>();
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        q.add(new int[]{sr,sc});
        tasveer[sr][sc]= NayaColor;
        
        while(!q.isEmpty()){
            int [] a= q.poll();
            int r=a[0];
            int c=a[1];
           
            
            for(int[] d:dir){
                int nr=d[0]+r;
                int nc=d[1]+c;
                if(nr>=0 && nr<n && nc>=0 && nc<m && tasveer[nr][nc]==old){
                    tasveer[nr][nc]=NayaColor;
                    q.add(new int[]{nr,nc});
                    
                }
                
            }


        }
     
        
    }
}