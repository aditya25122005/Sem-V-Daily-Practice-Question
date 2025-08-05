class Solution {
    public int longestPalindrome(String s) {
        int n= s.length();
        int totaleven=0;
        int totalodd=0;
        HashMap<Character,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        boolean ODD=false;
        for(int value:map.values()){
            if(value%2==0){
                totaleven+=value;
            }
            else{
                totalodd+=(value-1);
                ODD=true;
            }
        }
        int res=0;
        res+=totaleven;
        if(ODD)res+=1;
        res+=totalodd;
        return res;
        
    }
}