class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans = new ArrayList<>();
        for(String s: queries){
            int i=0;
            int j=0;
            boolean res=true;
            while(i<s.length() && j< pattern.length()){
                if(s.charAt(i)==pattern.charAt(j)){
                    i++;
                    j++;
                }
                else if(s.charAt(i)>='a' && s.charAt(i)<='z'){
                    i++;
                }
                else if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                    res=false;
                    break;
                }
            }
            // check all lefts are smaller in s
            while(i<s.length()){
                if(s.charAt(i)>='A' && s.charAt(i)<='Z'){
                    res=false;
                    break;
                }
                i++;
            }
            if(j<pattern.length()) res=false;
            ans.add(res);
        }
        return ans;
    }
}