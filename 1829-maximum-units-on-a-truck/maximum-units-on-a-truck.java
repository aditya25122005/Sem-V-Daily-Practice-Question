class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));
        int load=0;
        for(int [] a:boxTypes){
            int boxes=a[0];
            int Units=Math.min(truckSize,boxes);
            load+= Units*a[1];
            truckSize -= Units; 
            if(truckSize==0) break;
        }
        return load;
    }
}