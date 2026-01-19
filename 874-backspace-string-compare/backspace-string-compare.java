class Solution {
    public boolean backspaceCompare(String s, String t) {
        int c1=0;
        int c2=0;
        int n= s.length();
        int m= t.length();
        int i=n-1;
        int j=m-1;


        while(i>=0 && j>=0){
            while(i>=0 && s.charAt(i)=='#'){
                c1++;
                i--;
            }
            while(j>=0 && t.charAt(j)=='#'){
                c2++;
                j--;
            }
            while(i>=0 && c1>0 && s.charAt(i)!='#'){
                c1--;
                i--;
            }
            while(j>=0 && c2>0 && t.charAt(j)!='#'){
                c2--;
                j--;
            }
            if(i>=0 && j>=0 && s.charAt(i)!='#' && t.charAt(j)!='#'){
                if(s.charAt(i)!=t.charAt(j)){
                    return false;
                }
                else{
                    i--;
                    j--;
                }
            }
            if(i==-1 && j==-1){
                return true;
            }
        }
        while(i>=0){
            while(i>=0 && s.charAt(i)=='#'){
                c1++;
                i--;
            }
            while(i>=0 && c1>0 && s.charAt(i)!='#'){
                c1--;
                i--;
            }
            if(i>=0 && s.charAt(i)!='#'){
                return false;
            }
            if(i==0 && s.charAt(i)!='#'){
                return false;
            }
        }


        while(j>=0){
            while(j>=0 && t.charAt(j)=='#'){
                c2++;
                j--;
            }
            while(j>=0 && c2>0 && t.charAt(j)!='#'){
                c2--;
                j--;
            }
            if(j>=0 && t.charAt(j)!='#'){
                return false;
            }
            if(j==0 && t.charAt(j)!='#'){
                return false;
            }
            
        }

        return true;


    }
}