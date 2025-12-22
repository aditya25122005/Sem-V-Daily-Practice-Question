class Solution {
    public String pushDominoes(String dominoes) {
        int prev=0;

        String s="L"+dominoes+"R";
        char [] arr= s.toCharArray();
        for(int i=1;i<arr.length;i++){
            if(arr[i]=='.'){
                continue;
            }
            if(arr[i]=='R' && arr[prev]=='R'){
                for(int j=prev;j<=i;j++){
                    arr[j]='R';
                }
            }

            if(arr[i]=='L' && arr[prev]=='L'){
                for(int j=prev;j<=i;j++){
                    arr[j]='L';
                }
            }
            if(arr[prev]=='R' && arr[i]=='L'){
                int l=prev+1;
                int r=i-1;
                while(l<r){
                    arr[l]='R';
                    arr[r]='L';
                    l++;
                    r--;
                }

            }
            prev=i;
        }
        StringBuilder sb= new StringBuilder();
        for(int i=1;i<arr.length-1;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}