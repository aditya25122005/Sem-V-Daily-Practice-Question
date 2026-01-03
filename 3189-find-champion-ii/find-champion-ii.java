class Solution {
    public int findChampion(int n, int[][] edges) {
        int [] in= new int[n];
        for(int [] E:edges){
            int u=E[0];
            int v=E[1];
            in[v]++;
        }
        int c=0;
        int ans=-1;
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                if(c==0){
                    ans=i;
                    c++;
                }
                else{
                    ans=-1;
                    return ans;
                }
            }
        }
        return ans;
    }
}