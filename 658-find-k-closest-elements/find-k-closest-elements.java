class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ll= new ArrayList<>();
        int si=0;
        int ei=arr.length-1;
        while(ei-si>=k){
            if(Math.abs(arr[si]-x) > Math.abs(arr[ei]-x)){
                si++;
            }
            else{
                ei--;
            }
        }
        for(int i=si;i<=ei;i++){
            ll.add(arr[i]);
        }
        return ll;

    }
}