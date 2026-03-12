class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb= new StringBuilder();
        for(char ch: s.toCharArray()){
            if(Character.isDigit(ch) || Character.isAlphabetic(ch)){
                sb.append(ch);
            }
        }
        String str= sb.toString();
        
        str= str.toLowerCase();
        // System.out.println(str);
        int i=0;
        int j=str.length()-1;
        while(i<j){
            if(str.charAt(i)!= str.charAt(j)){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
        // s= s.toLowerCase();
        // int i=0;
        // int j= s.length()-1;
        // while(i<j){
        //     while(i<s.length()-1 && (!Character.isDigit(s.charAt(i)) || ! Character.isAlphabetic(s.charAt(i))) ){
        //         i++;
        //     }
        //     while(j>0 && (!Character.isDigit(s.charAt(j)) || ! Character.isAlphabetic(s.charAt(j))) ){
        //         j--;
        //     }
        //     if(s.charAt(i)!=s.charAt(j)){
        //         return false;
        //     }
           
        //     else{
        //         i++;
        //         j--;
        //     }

        // }
        // return true;
    }
}