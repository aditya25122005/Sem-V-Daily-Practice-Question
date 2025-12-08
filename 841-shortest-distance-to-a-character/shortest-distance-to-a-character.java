class Solution {
    public int[] shortestToChar(String s, char c) {
        int n= s.length();
        int [] ans= new int[n];
        List<Integer> ll= new ArrayList<>();// indies of c
        for(int i=0;i<n;i++){
            if(s.charAt(i)==c){
                ll.add(i);
            }
        }
        for(int i=0;i<n;i++){
            ans[i]=Solve(i,ll);
        }
        return ans;


    }
    public static int Solve(int i,List<Integer> ll){
        int min=Integer.MAX_VALUE;
        for(int idx:ll){
            min=Math.min(min,Math.abs(i-idx));
        }
        return min;
    }

}