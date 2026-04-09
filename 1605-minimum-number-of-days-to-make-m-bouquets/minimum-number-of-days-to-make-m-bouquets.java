class Solution {
    public int minDays(int[] bloom, int m, int k) {
        int n= bloom.length;
        if(n< m*k) return -1;
        int lo=1;
        int hi=0;
        for(int num: bloom){
            hi=Math.max(hi, num);
        }
        int ans=-1;
        while(lo<=hi){
            int mid= lo+(hi-lo)/2;
            if(isPossible(bloom, m, k, mid)){
                ans=mid;
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public static boolean isPossible(int [] bloom , int m, int k, int mid){
        int [] arr = bloom.clone();
        for(int i=0;i<arr.length;i++){
            arr[i] = Math.max(0, arr[i]-mid);
        }
        int count= 0;
        int i=0;
        while(i<arr.length){
            int c=0;
            while(i<arr.length && arr[i]==0){
                c++;
                if(c==k){
                     count++;
                     c=0;
                } 
                i++;
            }
            i++;
        }
        return count>=m;
    }
}