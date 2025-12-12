class Solution {
    public int diagonalPrime(int[][] nums) {
        int n= nums.length;
        int m=nums[0].length;
        int ans=0;
        int sr=0;
        int sc=0;
        while(sr<n && sc<n){
            if(check(nums[sr][sc])) ans=Math.max(ans,nums[sr][sc]);
            sr++;
            sc++;
        }
        sr=0;
        sc=m-1;
        while(sr<n  && sc>=0){
            if(check(nums[sr][sc])) ans=Math.max(ans,nums[sr][sc]);
            sr++;
            sc--;
        }
        
        return ans;
    }
    public static boolean check(int num){
        if(num<=1) return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}