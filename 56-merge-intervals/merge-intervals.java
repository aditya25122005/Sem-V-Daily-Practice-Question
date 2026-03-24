class Solution {
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums,(a,b)->Integer.compare(a[0],b[0]));
        int currStart= nums[0][0];
        int currEnd= nums[0][1];
        List<int[]> ll= new ArrayList<>();
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1][0]<= currEnd){
                currEnd= Math.max(currEnd,nums[i+1][1]);
            }
            else{
                ll.add(new int[]{currStart,currEnd});
                currStart= nums[i+1][0];
                currEnd=nums[i+1][1];
            }
            // if(i==nums.length-2){
            //     ll.add(new int[]{currStart,currEnd});
            // }

        }
        ll.add(new int[]{currStart,currEnd});
       int [][] arr= new int[ll.size()][2];
       int idx=0;
       for(int[] A: ll){
        arr[idx][0]=A[0];
        arr[idx][1]=A[1];
        idx++;
       }
       return arr;
       
    }
}