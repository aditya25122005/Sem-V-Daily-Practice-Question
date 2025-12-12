class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        // image[sr][sc]=color;
        Solve(image,sr,sc,color,image[sr][sc]);
        return image;
    }
    public static void Solve(int[][] arr, int cr, int cc, int color, int startColor){
        if(cr<0 || cc<0 || cr>=arr.length || cc>= arr[0].length || arr[cr][cc]!=startColor){
            return;
        }
        arr[cr][cc]= color;
    
        Solve(arr,cr+1,cc,color,startColor);
        Solve(arr,cr,cc+1,color,startColor);
        Solve(arr,cr-1,cc,color,startColor);
        Solve(arr,cr,cc-1,color,startColor);

    }
}