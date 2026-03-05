class Solution {
    public int minOperations(String s) {
        // 000000
        // 010101
        StringBuilder sb1= new StringBuilder();
        StringBuilder sb2= new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(i%2==0){
            sb1.append('1');
            sb2.append('0');
            }
            else{
                sb1.append('0');
                sb2.append('1');
            }
        }
        int c1=0;
        int c2=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != sb1.charAt(i)){
                c1++;
            }
            if(s.charAt(i) != sb2.charAt(i)){
                c2++;
            }
        }
        return Math.min(c1,c2);
    }
}