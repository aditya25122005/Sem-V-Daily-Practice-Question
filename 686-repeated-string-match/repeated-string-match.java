class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder A= new StringBuilder();
        A.append(a);
        StringBuilder s= new StringBuilder();
        s.append(a);
        int opr=1;

        while(A.length()<b.length()){
            opr++;
            A.append(a);
        }
        if(A.indexOf(b)!=-1) return opr;
        A.append(a);
        opr++;
        
        return A.indexOf(b)==-1? -1:opr;
    }
}