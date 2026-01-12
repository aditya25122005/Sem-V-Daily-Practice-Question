class Solution {
    public String countOfAtoms(String s) {
        Stack<HashMap<String,Integer>> st= new Stack<>();
        st.push(new HashMap<>());
        int n= s.length();
        int i=0;
        while(i<n){
            if(s.charAt(i)=='('){
                st.push(new HashMap<>());
                i++;
            }
            else if(s.charAt(i)==')'){
                HashMap<String,Integer> curr= st.pop();
                i++;
                int multiplier=0;
                
                while(i<n && Character.isDigit(s.charAt(i))){
                    multiplier= multiplier*10 + (s.charAt(i)-'0');
                    i++;
                }
                if(multiplier==0){
                    multiplier=1;
                }


                for(String str:curr.keySet()){
                        curr.put(str,curr.get(str)*multiplier);
                }
                
                for(String str:curr.keySet()){
                    int freq= curr.get(str);
                    if(st.peek().containsKey(str)){
                        int old= st.peek().get(str);
                        st.peek().put(str,old+freq);
                    }
                    else{
                        st.peek().put(str,freq);
                    }
                }
            }
            else{
                int start=i;
                i++;
                while(i<n && Character.isLowerCase(s.charAt(i))){
                    i++;
                }
                String curr= s.substring(start,i);
                int freq=0;

                StringBuilder sb= new StringBuilder();
                while(i<n && Character.isDigit(s.charAt(i))){
                    freq= freq*10 + s.charAt(i)-'0';
                    i++;
                }
                if(freq==0){
                    freq=1;
                }
              
                st.peek().put(curr,st.peek().getOrDefault(curr,0)+freq);
            }
        }
        StringBuilder res= new StringBuilder();
        TreeMap<String,Integer> mp= new TreeMap<>();
        for(String str:st.peek().keySet()){
            mp.put(str,st.peek().get(str));
        }   
        for(String str:mp.keySet()){
            res.append(str);
            int freq=mp.get(str);
            if(freq>1){
            res.append(mp.get(str));
            }
        }
        return res.toString();
    }
}