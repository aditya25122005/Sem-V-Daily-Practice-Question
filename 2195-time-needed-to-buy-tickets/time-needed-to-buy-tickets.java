class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {

        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            q.add(new int[]{arr[i],i});
        }
        int count=0;
        while(!q.isEmpty()){
            int [] rm= q.poll();
            // if(rm[1]==k){
                count++;
            // }
            
            rm[0]--;
            if(rm[1]==k && rm[0]==0){
                break;
            }
            if(rm[0]>0){
                q.add(new int[]{rm[0],rm[1]});
            }
        }
        return count;

    }
}