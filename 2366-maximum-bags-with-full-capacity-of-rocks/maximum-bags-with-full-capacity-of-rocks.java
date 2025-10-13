class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int extra) {
      int [] a= new int[rocks.length];
      int full=0;
      int max=0;
      for(int i=0;i<rocks.length;i++){
        a[i]=capacity[i]-rocks[i];
      }  
      Arrays.sort(a);
      for(int i=0;i<a.length;i++){
        if(a[i]!=0 && a[i]<=extra){
            extra-=a[i];
            full++;

        }
        if(a[i]==0){
            full++;
        }
      }
      return full;
    }
}