class Solution {
    public boolean hasMatch(String s, String p) {
        int idx = p.indexOf('*'); //2;
        String sub1 ="";
        if(idx>0){
            sub1= p.substring(0,idx);
        }
        String sub2="";
        if(idx<p.length()-1){
            sub2= p.substring(idx+1);
        }
        int i1 = s.indexOf(sub1);
        if(!sub1.equals("") && i1==-1) return false;

        int i2 = s.indexOf(sub2, i1+sub1.length());
        if(!sub2.equals("") && i2==-1){
            return false;
        }
        return true;
    }
}