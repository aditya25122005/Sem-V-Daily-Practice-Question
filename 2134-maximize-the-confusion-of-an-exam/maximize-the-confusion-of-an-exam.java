class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int A= SolveT(answerKey,k);
        int B= SolveF(answerKey,k);
        return Math.max(A,B);
    }
    public static int SolveF(String s, int k){
        int curr=0;
        int ans=0;
        int si=0;
        int ei=0;
        int used=0;
        char [] arr= s.toCharArray();
        while(ei<arr.length){
            char ch= arr[ei];
            if(ch=='F'){
                curr++;
                ans=Math.max(ans,curr);
            }
            else {
                if(used<k){
                    used++;
                    curr++;
                    ans=Math.max(ans,curr);
                }
                else{
                    ans=Math.max(ans,curr);
                    while(used>=k){
                        if(arr[si]=='T'){
                            used--;
                        }
                        curr--;
                        si++;
                    }
                    curr++;
                    used++;
                }
            }
            ans=Math.max(ans,curr);
            ei++;
        }
        return ans;

    }
    public static int SolveT(String s, int k){
        int curr=0;
        int ans=0;
        int si=0;
        int ei=0;
        int used=0;
        char [] arr= s.toCharArray();
        while(ei<arr.length){
            char ch= arr[ei];
            if(ch=='T'){
                curr++;
                ans=Math.max(ans,curr);
            }
            else {
                if(used<k){
                    used++;
                    curr++;
                    ans=Math.max(ans,curr);
                }
                else{
                    ans=Math.max(ans,curr);
                    while(used>=k){
                        if(arr[si]=='F'){
                            used--;
                        }
                        curr--;
                        si++;
                    }
                    curr++;
                    used++;
                }
            }
            ans=Math.max(ans,curr);
            ei++;
        }
        return ans;

    }
}