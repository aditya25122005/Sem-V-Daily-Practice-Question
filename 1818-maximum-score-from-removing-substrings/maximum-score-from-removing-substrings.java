class Solution {
    public int maximumGain(String s, int x, int y) {
        int total=0;
        String top="";
        String bot="";
        int topscore=0;
        int botscore=0;
        if(x>y){
            top="ab";
            topscore=x;
            bot="ba";
            botscore=y;
        }
        else{
            top="ba";
            topscore=y;
            bot="ab";
            botscore=x;
        }

        Stack<Character> st= new Stack<>();
        for(char ch:s.toCharArray()){
            if( !st.isEmpty() &&ch==top.charAt(1) && st.peek()==top.charAt(0)){
                total+=topscore;
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder rem= new StringBuilder();
        while(!st.isEmpty()){
            rem.append(st.pop());
        }
        rem.reverse();
        


        Stack<Character> ST= new Stack<>();
        for(char ch:rem.toString().toCharArray()){
          
            if(!ST.isEmpty() &&ch==bot.charAt(1) && ST.peek()==bot.charAt(0)){
                total+=botscore;
                ST.pop();
            }
            else{
                ST.push(ch);
            }
                       
        }
        return total;
    }
}