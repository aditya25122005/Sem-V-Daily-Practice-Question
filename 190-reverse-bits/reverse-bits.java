class Solution {
    public int reverseBits(int n) {
        String s= String.format("%32s", Integer.toBinaryString(n));
     
        StringBuilder sb= new StringBuilder(s);
        sb.reverse();
        s=sb.toString();
        int p=0;
        long ans=0;
        System.out.println(s);
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                ans= ans+ (int)Math.pow(2,p);
            }
            p++;
        }
        return (int)ans;
    }
}