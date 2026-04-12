class Solution {
    public int minimumDistance(String word) {
        // Integer[][][] dp= new Integer[word.length()][]
        HashMap<String,Integer> dp= new HashMap<>();
        return Solve(word, 0,-1,-1,dp);
    }
    public static int Solve(String word, int idx, int i, int j, HashMap<String,Integer> dp){
        if(idx==word.length()){
            return 0;
        }
        String key= idx+"*"+i+"*"+j;
        if(dp.containsKey(key)) return dp.get(key);
        // press this word with first finger;
        int A = Integer.MAX_VALUE;

        if(i==-1){
            int x1= (word.charAt(idx)-'A')/6;
            int y1= (word.charAt(idx)-'A')%6;
            A = Solve(word,idx+1,idx,j,dp);
        }
        else{
            int x1= (word.charAt(idx)-'A')/6;
            int y1= (word.charAt(idx)-'A')%6;
            int x2= (word.charAt(i)-'A')/6;
            int y2= (word.charAt(i)-'A')%6;
            int dis= Math.abs(x1-x2)+Math.abs(y1-y2);
            A= dis+ Solve(word,idx+1,idx,j,dp);
        }

        // press this word with 2nd finger

        int B = Integer.MAX_VALUE;

        if(j==-1){
            int x1= (word.charAt(idx)-'A')/6;
            int y1= (word.charAt(idx)-'A')%6;
            B = Solve(word,idx+1,i,idx,dp);
        }
        else{
            int x1= (word.charAt(idx)-'A')/6;
            int y1= (word.charAt(idx)-'A')%6;
            int x2= (word.charAt(j)-'A')/6;
            int y2= (word.charAt(j)-'A')%6;
            int dis= Math.abs(x1-x2)+Math.abs(y1-y2);
            B= dis+ Solve(word,idx+1,i,idx,dp);
        }
        dp.put(key, Math.min(A,B));
        return  Math.min(A,B);


    }

}