class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            while(s.charAt(i)==' ' || !((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)<='9' && s.charAt(i)>='0'))){
                i++;
                if(i>j) return true;
            }

            while(s.charAt(j)==' ' || !((s.charAt(j)>='a' && s.charAt(j)<='z') || (s.charAt(j)<='9' && s.charAt(j)>='0'))){
                j--;
                if(j<i) return true;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }
}