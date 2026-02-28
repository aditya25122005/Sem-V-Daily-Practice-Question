class Solution {
    public String mergeCharacters(String s, int k) {
        boolean change=true;
        while(change){
            change=false;
            for(int i=0;i<s.length();i++){
                for(int j=i+1; j<=i+k && j<s.length();j++){
                    if(s.charAt(i)==s.charAt(j)){
                        s= s.substring(0,j)+ s.substring(j+1);
                        change=true;
                        break;
                    }
                }
                if(change){
                    break;
                }
            }
        }
        return s;
    }
}