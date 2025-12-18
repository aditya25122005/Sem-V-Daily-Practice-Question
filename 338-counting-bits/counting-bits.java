class Solution {
    public int[] countBits(int n) {
        int[] ans= new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=count1(i);
        }
        return ans;
    }
    public static int count1(int n){
        int c=0;
        while(n!=0){
            n=n&(n-1);
            c++;
            // if((n&1) == 1){
            //     c++;
               
            // }
            // n=n>>1;
           
        }
        return c;
    }
}