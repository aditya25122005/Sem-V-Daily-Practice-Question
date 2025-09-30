class Solution {
    public int characterReplacement(String s, int k) {
        return Solve(s,k);
    }
    public static int Solve(String s, int k){
        int ans=0;
        for(char ch='A';ch<='Z';ch++){
            ans=Math.max(ans,check(s,k,ch));
        }
        return ans;
    }
    public static int check(String s, int k, char ch){
        int si=0;
        int ei=0;
        int ans=0;
        int flip=0;
        while(ei<s.length()){
            if(s.charAt(ei)!=ch){
                flip++;
            }
            while(flip>k){
                if(s.charAt(si)!=ch){
                    flip--;
                }
                si++;
            }
            ans=Math.max(ans,ei-si+1);
            ei++;
        }
        return ans;
    }
}