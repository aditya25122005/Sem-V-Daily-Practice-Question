class Solution {
    static int ans;
    static int [] memo;
    public int minCut(String s) {
        // if(isPalindrome(s,0,s.length()-1)){
        //     return 0;
        // }
        List<String> l1= new ArrayList<>();
        List<List<String>> ll= new ArrayList<>();
        ans=Integer.MAX_VALUE;
        boolean[][] dp= new boolean[s.length()][s.length()];
        int n=s.length();
        for(int i=0;i<n;i++){
            dp[i][i]=true; // 1 length substring always palindrome
        }
        for(int len=2;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(len==2){
                    dp[i][j]=s.charAt(i)==s.charAt(j);
                }else{
                    dp[i][j]=s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
                }
            }
        }
        memo=new int[n];
        Arrays.fill(memo,-1);
        return Solve(s,0,dp) -1 ;
        
    }
    public static int Solve(String s, int idx,boolean[][]dp){
        if(idx==s.length()){
            return 0;
        }
        if(memo[idx]!=-1){
            return memo[idx];
        }
        int minCut=Integer.MAX_VALUE;
        for(int cut=idx;cut<s.length();cut++){
            if(dp[idx][cut]){
                minCut=Math.min(minCut,1+Solve(s,cut+1,dp));         
            }
        }
        return memo[idx]=minCut;
    }
    public static boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}