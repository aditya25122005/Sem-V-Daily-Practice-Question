class Solution {
    public boolean isDigitorialPermutation(int n) {
        int [] fact= {1,1,2,6,24,120,720,5040,40320,362880};
        int num=n;
        int sum=0;
        while(n!=0){
            int d= n%10;
            sum+= fact[d];
            n/=10;
        }
        int [] a= new int[10];
        int [] b= new int[10];
        for(char ch: String.valueOf(sum).toCharArray()){
            a[ch-'0']++;
        }
        for(char ch: String.valueOf(num).toCharArray()){
            b[ch-'0']++;
        }
        return Arrays.equals(a,b);




    }
}