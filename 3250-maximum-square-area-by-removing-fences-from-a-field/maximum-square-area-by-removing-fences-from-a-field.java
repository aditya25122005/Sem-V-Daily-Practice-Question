class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int [] H= new int[hFences.length+2];
        int [] V= new int[vFences.length+2];
        H[0]=1;
        V[0]=1;
        H[H.length-1]=m;
        V[V.length-1]=n;


        int idx=0;
        int jdx=0;
        for(int i=1;i<H.length-1;i++){
            H[i]=hFences[idx];
            idx++;
        }
        for(int i=1;i<V.length-1;i++){
            V[i]=vFences[jdx];
            jdx++;
        }
        Arrays.sort(H);
        Arrays.sort(V);

        HashSet<Integer> hh= new HashSet<>();
        for(int i=0;i<H.length;i++){
            for(int j=i+1;j<H.length;j++){
                int diff = H[j]-H[i];
                hh.add(diff); 
            }
        }
        long maxArea=-1;
        for(int i=0;i<V.length;i++){
            for(int j=i+1;j<V.length;j++){
                int curr= V[j]-V[i];
                if(hh.contains(curr)){
                    maxArea=Math.max(maxArea,(long)curr*curr);
                }
            }
        }
        return (int)(maxArea%1000000007);
    }
}