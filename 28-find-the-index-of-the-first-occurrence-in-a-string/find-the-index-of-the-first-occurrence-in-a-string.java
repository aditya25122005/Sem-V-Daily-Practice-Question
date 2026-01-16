class Solution {
    public int strStr(String s1, String s2) {
        // return s1.indexOf(s2);
        if(s1.length()<s2.length()) return -1;
        for(int i=0;i<s1.length();i++){
            
            if(s1.charAt(i)==s2.charAt(0)){
            int start=i;
            boolean isPossible=true;
            int idx=i;
            int covered=0;
                for(int j=0;j<s2.length() && idx<s1.length();j++){
                    if(s2.charAt(j)!=s1.charAt(idx)){
                        isPossible=false;
                        break;
                    }
                    covered++;
                  
                        idx++;
                    
                }
                if(covered<s2.length()) isPossible=false;

                if(isPossible) return start;
            }
        }
        return -1;


    }
}