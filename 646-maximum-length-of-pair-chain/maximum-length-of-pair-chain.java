class Solution {
    public int findLongestChain(int[][] pairs) {
        int n= pairs.length;
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int b= pairs[0][1];
        int count=1;
        for(int i=1;i<n;i++){
            int c=pairs[i][0];
            int d=pairs[i][1];
            if(c>b){
                count++;
                b=d;
            }
        }
        
        return count;
    }
}