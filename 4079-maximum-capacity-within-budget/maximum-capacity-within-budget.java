class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n= capacity.length;
        int [][] A= new int [n][2];
        for(int i=0;i<A.length;i++){
            A[i][0]= costs[i];
            A[i][1]= capacity[i];
        }
        Arrays.sort(A,(a,b)->a[0]-b[0]);
        int ans=0;
        for(int i=0;i<n;i++){
            if(A[i][0]<budget){
                ans=Math.max(ans,A[i][1]);
            }
        }
        int [] prefix= new int [n];
        prefix[0] = A[0][1];
        for(int i=1;i<n;i++){
            prefix[i]=Math.max(prefix[i-1],A[i][1]);
        }

        for(int i=1;i<n;i++){
            int remaining= budget-A[i][0]-1;
            int lo=0;
            int hi=i-1;
            int currAns=Integer.MIN_VALUE;
            while(lo<=hi){
                int mid= lo+(hi-lo)/2;
                if(A[mid][0]<=remaining){
                    currAns=Math.max(currAns,prefix[mid]);
                    lo=mid+1;
                }
                else{
                    hi=mid-1;
                }
            }
            if(currAns!=Integer.MIN_VALUE){
                ans=Math.max(ans, currAns+A[i][1]);
            }
        }
        return ans;
    }
}