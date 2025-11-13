class Solution {
    public int maxOperations(String s) {
        int one=0;
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                one++;
            }
            
            if(i>0 && s.charAt(i)<s.charAt(i-1)){
                    cnt+=one;
            }
            
        }

       
        return cnt;
    }
}