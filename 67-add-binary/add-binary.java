class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res= new StringBuilder();
        int i= a.length()-1;
        int j= b.length()-1;
        int carry = 0;
        // sum is 2-> add 0 in ans, 1 in carry
        // sum is 3-> add 1 in ans, 1 in carry
        while(i>=0 && j>=0){
            int val1= a.charAt(i)-'0';
            int val2= b.charAt(j)-'0';
            int sum = carry+ val1 + val2;
            if(sum==0){
                res.append(0);
                carry=0;
            }
            if(sum==1){
                res.append(1);
                carry=0;
            }
            if(sum==2){
                res.append(0);
                carry=1;
            }
            if(sum==3){
                res.append(1);
                carry=1;
            }
            i--;
            j--;
        }
        while(i>=0){
            int val= a.charAt(i)-'0';
            int sum= val+ carry;
             if(sum==0){
                res.append(0);
                carry=0;
            }
            if(sum==1){
                res.append(1);
                carry=0;
            }
            if(sum==2){
                res.append(0);
                carry=1;
            }
            i--;
        }
         while(j>=0){
            int val= b.charAt(j)-'0';
            int sum= val+ carry;
             if(sum==0){
                res.append(0);
                carry=0;
            }
            if(sum==1){
                res.append(1);
                carry=0;
            }
            if(sum==2){
                res.append(0);
                carry=1;
            }
            j--;
        }
        if(carry!=0){
            res.append(carry);
        }
        return res.reverse().toString();
    }
}