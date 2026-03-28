class Solution {
    public int[] decrypt(int[] code, int k) {
        int n= code.length;
        int [] ans=new int[code.length];
        int [] arr = new int[n*2];
        for(int i=0;i<n;i++){
            arr[i]=code[i];
            arr[i+n]=code[i];
        }
        
        for(int i=n;i<2*n;i++){
            int sum=0;
            if(k>0){
                for(int j=i+1;j<i+1+k;j++){
                    sum+= arr[j%n];
                }

            }
            else if(k<0){
                int t = k*-1;
                for(int j=i-t;j<i;j++){
                    sum+= arr[j];
                }
            }
            ans[i%n]=sum;
        }
        return ans;
    }
}