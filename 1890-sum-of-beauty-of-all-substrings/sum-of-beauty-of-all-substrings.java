class Solution {
    public int beautySum(String s) {
        // HashMap<Character,Integer> map= new HashMap<>();
        // for(char ch:s.toCharArray()){
        //     map.put(ch,map.getOrDefault(ch,0)+1);
        // }
        int count=0;
        for(int i=0;i<s.length();i++){
            int [] freq= new int[26];
            
            for(int j=i;j<s.length();j++){

                freq[s.charAt(j)-'a']++;
                int min=Integer.MAX_VALUE;
                int max=Integer.MIN_VALUE;
                for(int k=0;k<26;k++){
                    if(freq[k]>max){
                        max=freq[k];
                    }
                    if(freq[k]>0 && freq[k]<min){
                        min=freq[k];
                    }
                }
                count+= max-min;
                
            }
        } 
        return count;
    }
    // public static int find(String s){
    //     HashMap<Character,Integer> map= new HashMap<>();
    //     for(char ch:s.toCharArray()){
    //         map.put(ch,map.getOrDefault(ch,0)+1);
    //     }
    //     int min=Integer.MAX_VALUE;
    //     for(char key:map.keySet()){
    //         int freq=map.get(key);
    //         min=Math.min(min,freq);
    //     }

    //     int max=Integer.MIN_VALUE;
    //     for(char key:map.keySet()){
    //         int freq=map.get(key);
    //         max=Math.max(max,freq);
    //     }
    //     return max-min;
    // }
}