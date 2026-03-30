class Solution {
    public int[] diStringMatch(String s) {
        int a=0;
        int b=s.length();
        int [] arr= new int[s.length()+1];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I'){
                arr[i]=a;
                a++;
            }
            else if(s.charAt(i)=='D'){
                arr[i]=b;
                b--;
            }
        }
        arr[arr.length-1]=a;
        return arr;
    }
}