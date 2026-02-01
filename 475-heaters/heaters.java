class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int lo=0;
        int hi=Math.max(houses[houses.length-1],heaters[heaters.length-1]);
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isOk(houses,heaters,mid)){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;

    }
    public static boolean isOk(int[] houses, int[] heaters, int R){
        
        for(int h:houses){
            int idx=Arrays.binarySearch(heaters,h);
            if(idx<0){ // bs returns  -(insertionPoint) - 1;
                idx= -idx-1;
            }
            
            int nearest= Integer.MAX_VALUE;
            if(idx<heaters.length){
                nearest= Math.min(nearest, heaters[idx]-h);
            }
            
            //check in left
            if(idx>0){
                nearest=Math.min(nearest, h-heaters[idx-1]);
            }
            if(nearest>R){
                return false;
            }
           
        }
        return true;
    }
}