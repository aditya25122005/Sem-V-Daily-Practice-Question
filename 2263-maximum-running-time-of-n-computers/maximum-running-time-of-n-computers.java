class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum=0;
        for(int num:batteries){
            sum+= (long)num;
        }
        long lo=1;
        long hi=sum;
        long ans=0;

        while(lo<=hi){
            long mid= lo+(hi-lo)/2;
            if(isPossible(batteries,n,mid)){
                ans=mid;
                lo=mid+1;
            }
            else{
                hi=mid-1;
            }
        }
        return ans;
    }

    public static boolean isPossible(int[] arr, int comp, long M){
       long sum=0;
       for(int num:arr){
        sum+=Math.min((long)num,M);
       }
       if(sum>= comp*M){
        return true;
       }
        
        return false;
    }
}
