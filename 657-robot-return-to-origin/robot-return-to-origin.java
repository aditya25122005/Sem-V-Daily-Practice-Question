class Solution {
    public boolean judgeCircle(String moves) {
        int cr=0;
        int cc=0;
        for(char ch: moves.toCharArray()){
            if(ch=='U'){
                cr--;
            }
            else if(ch=='D'){
                cr++;
            }
            else if(ch=='R'){
                cc++;
            }
            else if(ch=='L'){
                cc--;
            }
        }
        return cr==0 && cc==0;
    }
}