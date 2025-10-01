class Solution {
    public int maximumUnits(int[][] boxTypes, int truck) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1],a[1]));

        int load=0;
        int i=0;
        while(i<boxTypes.length && truck>0 ){
            if(boxTypes[i][0]<=truck){
                load+= boxTypes[i][0]*boxTypes[i][1];
                truck-=boxTypes[i][0];
                i++;
            }else{
                load+= truck*boxTypes[i][1];
                truck=0;
                i++;
            }
        }

        return load;
    }
}