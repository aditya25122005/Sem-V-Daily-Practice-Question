class Solution {
    public int[] sortByBits(int[] arr) {
        Integer [] A= new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            A[i]=arr[i];
        }
        Arrays.sort(A,(a,b)-> {
        int diff = setBit(a) - setBit(b);
        if(diff == 0){
            return a - b;   
        }
        return diff;
        });
           
        for(int i=0;i<arr.length;i++){
            arr[i]=A[i];
        }
        return arr;
    }
    public static int setBit(int num){
        int set=0;
        while(num!=0){
            if((num&1)!=0){
                set++;
            }
            num>>=1;
        }
        return set;
    }
}