class Solution {
    public long countPairs(String[] words) {
        long count=0;
        String [] w= new String[words.length];
        HashMap<String,Long> map= new HashMap<>();
        int idx=0;
        for(String s:words){
            int shift= s.charAt(0)-'a';
            StringBuilder sb= new StringBuilder();
            for(int i=0;i<s.length();i++){
                // char newChar = (s.charAt(i)-shift+26)%26;
                char newChar= (char)((s.charAt(i)-'a'-shift+26)%26+'a');
                sb.append(newChar);
            }
            map.put(sb.toString(),map.getOrDefault(sb.toString(),(long)0)+1);
        }
        
        for(String key:map.keySet()){
            long f= map.get(key);
            count+= f*(f-1)/2;
        }
        return count;
    }
}