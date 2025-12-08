class Solution {
    public int countTriples(int n) {
        int c=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int sum= i*i+j*j;
                int root=(int)Math.sqrt(sum);
                if(root*root==sum && root<=n){
                    c++;
                }
            }
        }
        return c;
    }
}