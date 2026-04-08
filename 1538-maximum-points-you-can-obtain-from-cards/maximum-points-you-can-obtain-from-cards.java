class Solution {
    public int maxScore(int[] card, int k) {
        int sum=0;
        for(int num: card){
            sum+= num;
        }
        int n= card.length;
        int curr=0;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<n-k;i++){
            curr+= card[i];
        }
        int win =n-k;
        ans=Math.min(ans,curr);
        for(int i=n-k;i<n;i++){
            curr-= card[i-win];
            curr+= card[i];
            ans=Math.min(ans,curr);
        }
        return sum - ans;
        
        // return Solve(cardPoints,0,cardPoints.length-1,k);
    }

    // public static int Solve(int [] arr, int i, int j, int k){
    //     if(k==0){
    //         return 0;
    //     }
    //     if(i>j){
    //         return 0;
    //     }
     
    //     int A= arr[i]+ Solve(arr,i+1,j,k-1);
    //     int B= arr[j]+ Solve(arr,i,j-1,k-1);
    //     return  Math.max(A,B);

    // }
}