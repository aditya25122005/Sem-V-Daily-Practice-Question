class Solution {
    int n;
    int[][] palindrome;
    int[] [] dp;

    public int palindromePartition(String s, int k) {
        n=s.length();
        palindrome= new int[n][n];
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                
                palindrome[i][j]=palindrome[i+1][j-1]+(s.charAt(i)==s.charAt(j)? 0:1);

            }
        }
        dp= new int[n][k+1];
        for(int [] a:dp){
            Arrays.fill(a,-1);
        }
        return solve(0,k);

    }
    public  int solve(int idx, int k){
        if(k==1){
            return palindrome[idx][n-1]; //No Partition -> return cost of making full substr a palindrome
        }
        if(dp[idx][k]!=-1){
            return dp[idx][k];
        }
        int ans=n; // change all chars
        for(int i=idx;i<=n-k;i++){   // s="abcdef" last index of i for k=3 -> 3
            int res=palindrome[idx][i];
            res+=solve(i+1,k-1); // 1 partition done so k-1
            ans=Math.min(ans,res);
        }

        return dp[idx][k]=ans;
    }
}