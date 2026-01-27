class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        int ans=0;
        for(int i=0;i<=k;i++){
            ans+= Math.min(arr[i],arr[k]);
        }
        for(int i=k+1;i<arr.length;i++){
            ans+= Math.min(arr[i],arr[k]-1); // we dont need to make elements 0 that are ahead of k
        }
        return ans;
        // Queue<int[]> q= new LinkedList<>();
        // for(int i=0;i<arr.length;i++){
        //     q.add(new int[]{arr[i],i});
        // }
        // int count=0;
        // while(!q.isEmpty()){
        //     int [] rm= q.poll();
        //     // if(rm[1]==k){
        //         count++;
        //     // }
            
        //     rm[0]--;
        //     if(rm[1]==k && rm[0]==0){
        //         break;
        //     }
        //     if(rm[0]>0){
        //         q.add(new int[]{rm[0],rm[1]});
        //     }
        // }
        // return count;

    }
}