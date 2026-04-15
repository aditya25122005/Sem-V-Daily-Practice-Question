class Solution {
    public int maxRepOpt1(String text) {
        int n=text.length();
        int res=0;
        for(char ch='a';ch<='z';ch++){
            int si=0;
            int ei=0;
            int curr=0;
            int ans=0;
            boolean used=false;
            int total=0;
            for(char c: text.toCharArray()){
                if(c==ch)total++;
            }
            while(ei<n){
                if(text.charAt(ei)==ch){
                    curr++;
                }
                else{
                    if(!used){
                        curr++;
                        used=true;
                    }
                    else{
                        while(si<=ei && used){
                            curr--;
                            if(text.charAt(si)!=ch){
                                used=false;
                                si++;
                                break;
                            }
                            else{
                                si++;
                            }
                        }
                        used=true;
                        curr++;
                    }
                    
                }
                ans=Math.max(ans, Math.min(curr,total));
                ei++;
            }
            res=Math.max(res,ans);
        }
        return res;
    }
}