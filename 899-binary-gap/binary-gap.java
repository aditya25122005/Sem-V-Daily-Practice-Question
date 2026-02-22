class Solution {
    public int binaryGap(int n) {
        String s= Integer.toBinaryString(n);
        int curr=0;
        int max=0;
        int prev=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                if(prev!=-1){
                    max=Math.max(max,i-prev);
                    
                }
                prev=i;
            }
        }
        return max;
    }
}