class Solution {
    public int maxProduct(int n) {
        int [] arr= new int [10];
        int idx=0;
        int max=0;
        while(n>0){
            arr[idx++]=n%10;
            n/=10;
        }
        for(int i=0;i<idx;i++){
            for(int j=i+1;j<idx;j++){
                int prod=arr[i]*arr[j];
                if(prod>max) max=prod;
            }
        }
        return max;
    }
}