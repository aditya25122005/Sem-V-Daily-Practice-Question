class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        int c=0;
        boolean[] used= new boolean[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(baskets[j]>=fruits[i]  && used[j]==false){
                    used[j]=true;
                    c++;
                    break;
                }
            }

        }
        return n-c;
    }
}