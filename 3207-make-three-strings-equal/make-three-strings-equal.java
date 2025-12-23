class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        if(s1.charAt(0)!=s2.charAt(0) || s2.charAt(0)!=s2.charAt(0) || s1.charAt(0)!=s3.charAt(0)){
            return -1;
        }
        int c=0;
        int min=Math.min(s1.length(),Math.min(s2.length(),s3.length()));
        for(int i=0;i<min;i++){
            if(!(s1.charAt(i)==s2.charAt(i) && s2.charAt(i)==s3.charAt(i))){
                c+= 3*(min-i);
                break;
            }
        }
        if(s1.length()!=min) c+=s1.length()-min;
        if(s2.length()!=min) c+=s2.length()-min;
        if(s3.length()!=min) c+= s3.length()-min;
        return c;
        
    }
}