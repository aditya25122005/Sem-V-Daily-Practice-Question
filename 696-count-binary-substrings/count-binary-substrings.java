class Solution {
    public int countBinarySubstrings(String s) {
        /*
        00110011
        [2,2,2,2]
        2+2+2=6

        10101
        [1,1,1,1,1]
        1+1+1+1=4
        */

        int c=1;
        List<Integer> ll= new ArrayList<>();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                c++;
                
            }
            else{
                ll.add(c);
                c=1;
            }
            if(i==s.length()-1){
                ll.add(c);
            }
        }
        int ans=0;
        if(ll.size()==1){
            return 0; // all 0 or all 1
        }
        for(int i=0;i<ll.size()-1;i++){
            ans+= Math.min(ll.get(i),ll.get(i+1));
        }
        return ans;
    }
}