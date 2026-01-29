class Solution {
    public long maxTotal(int[] value, int[] limit) {
        int n= value.length;
        int [][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0]=limit[i];
            arr[i][1]=value[i];
        } 
        Arrays.sort(arr,(a,b)->{
            if(a[0]!=b[0]){
                return a[0]-b[0];
            }
            return b[1]-a[1];
        });
        int global=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();

        long ans=0;
        for(int i=0;i<arr.length;i++){
            int lim= arr[i][0];
            int v= arr[i][1];
            if(pq.size()<lim && lim>global){ // global is max. active element till Now-> If max_Active_Till_Now(x) >= lim then we can not active
                ans+=(long)v;
                pq.add(lim);

                int x= pq.size();
                global= Math.max(global,x);

                while(!pq.isEmpty() && pq.peek()<=x){
                    pq.poll();
                }
            }
           
           
        }


        return ans;
    }
}