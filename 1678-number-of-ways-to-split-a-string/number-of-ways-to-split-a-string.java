class Solution {
    public int numWays(String s) {
        int one=0;
        int n=s.length();
        for(char ch:s.toCharArray()){
            if(ch=='1'){
                one++;
            }
        }
        if(one==0){
            long res=((long)(n-1)*(n-2)/2)%1000000007;
            return (int) res;
        } 
        if(one%3!=0) return 0;
        int i1=0;
        int o=0;
        long mul=1;
        // 1000101_0000_100101_111

        int part=one/3; //Let  12/3-->4
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                o++;
                if(o==part){
                    i1=i;
                    for(int j=i1+1;j<n;j++){
                        if(s.charAt(j)=='1'){
                            mul=(mul*(j-i1))%1000000007;;
                            break;
                        }
                    }
                    o=0;
                }
            }
        }
        return (int)(mul%1000000007);

    }
}