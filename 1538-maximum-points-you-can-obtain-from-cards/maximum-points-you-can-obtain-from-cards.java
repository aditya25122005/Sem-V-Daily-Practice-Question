class Solution {
    public int maxScore(int[] arr, int k) {
        int n = arr.length;
        int size = n-k;
        int total = 0;
        for(int num: arr){
            total+= num;
        }
        int si=0;
        int ei=0;
        int curr=0;
        int minSum = Integer.MAX_VALUE;
        while(ei<n){
            curr+= arr[ei];
            if(ei-si+1 == size){
                minSum = Math.min(minSum,curr);
            }
            while(ei-si+1 > size){
                curr -= arr[si];
                si++;
            }
            if(ei-si+1 == size){
                minSum = Math.min(minSum,curr);
            }
            ei++;
        }
        return total- minSum;
    }
}