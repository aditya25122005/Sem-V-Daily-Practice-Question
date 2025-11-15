class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n= s.length();
        int [] prefix= new int[s.length()];
        int [] suffix= new int[s.length()];
        int [] star= new int[s.length()];
        if(s.charAt(0)=='|'){
            prefix[0]=0;
        }
        else{
            prefix[0]=-1;
        }
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='|'){
                prefix[i]=i;
            }
            else{
                prefix[i]=prefix[i-1];
            }
        }

        if(s.charAt(n-1)=='|'){
            suffix[n-1]=n-1;
        }
        else{
            suffix[n-1]=-1;
        }
        for(int i=n-2;i>=0;i--){
            if(s.charAt(i)=='|'){
                suffix[i]=i;
            }
            else{
                suffix[i]=suffix[i+1];
            }
        }
        if(s.charAt(0)=='*'){
            star[0]=1;
        }
        else{
            star[0]=0;
        }
        for(int i=1;i<n;i++){
            if(s.charAt(i)=='*'){
                star[i]=star[i-1]+1;
            }
            else{
                star[i]=star[i-1];
            }
        }

        int[] ans= new int[queries.length];
        int idx=0;

        for(int[] Q:queries){
         
            int si=Q[0];
            int ei=Q[1];
            int left= suffix[si];
            int right=prefix[ei];
            if(left==-1 || right==-1 || left>=right){
                ans[idx++]=0;

            }
            else{
                ans[idx++]=star[right]-star[left];
            }
        


        }
        return ans;

        
        


       
    }
}