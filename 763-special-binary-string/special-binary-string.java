class Solution {
    public String makeLargestSpecial(String s) {
        //    ((())())
        // (    (()) ,   ()    )
        return Largest(s);
        
    }
    public static String Largest(String s){
        List<String> ll= new ArrayList<>();
        int cnt=0;
        int si=0;
        for(int ei=0;ei<s.length();ei++){
            if(s.charAt(ei)=='0') cnt--;
            else cnt++;
            if(cnt==0){
                String inner= s.substring(si+1,ei);
                ll.add("1"+Largest(inner)+"0");
                si=ei+1;
            }
        }
        Collections.sort(ll,Collections.reverseOrder());
        // System.out.println(ll);
        StringBuilder ans= new StringBuilder();
        for(String ss:ll){
            ans.append(ss);
        }
        
        return ans.toString();
    }
}