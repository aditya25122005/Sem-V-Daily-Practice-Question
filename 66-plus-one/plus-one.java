class Solution {
    public int[] plusOne(int[] digits) {
        int num=0;
        int n=digits.length;
        if(digits[digits.length-1]<=8) {
            digits[n-1]++;
            return digits;
        }
        int [] f= new int[n+1];
        f[0]=1;
        for(int i=n-1;i>=0;i--){
            if(digits[i]==9){
                digits[i]=0;
            }
            else{
                digits[i]++;
                return digits;
            }
        }
        return f;
        

       
      
    }
}