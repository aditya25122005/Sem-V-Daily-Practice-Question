class Solution {
    public boolean isDigitorialPermutation(int n) {
          int [] fact = {1,1,2,6,24,120,720,5040,40320,362880};

          int num=n;
          int sum=0;
          while(num!=0){
            int rem= num%10;
            sum+= fact[rem];
            num/=10;
          }

          char [] a= String.valueOf(sum).toCharArray();
          char [] b= String.valueOf(n).toCharArray();
          Arrays.sort(a);
          Arrays.sort(b);
          return Arrays.equals(a,b);
    }
}