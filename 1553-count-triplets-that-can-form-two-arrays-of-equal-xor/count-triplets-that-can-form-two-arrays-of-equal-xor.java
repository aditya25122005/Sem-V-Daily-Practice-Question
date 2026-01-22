class Solution {
    int count=0;
    public int countTriplets(int[] arr) {
        
        for(int i=0;i<arr.length-1;i++){
            int xor_a=0;
            for(int j=i+1;j<arr.length;j++){
                xor_a^= arr[j-1];
                
                int xor_b=0;
                for(int k=j;k<arr.length;k++){
                    xor_b^=arr[k];
                    if(xor_a == xor_b){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public static boolean isValid(int i, int j, int k, int []arr){
        int xora=0;
        int xorb=0;

        for(int p=i;p<j;p++){
            xora^= arr[p];
        }
        for(int q=j;q<=k;q++){
            xorb^= arr[q];
        }
        return xora==xorb;
    }
}