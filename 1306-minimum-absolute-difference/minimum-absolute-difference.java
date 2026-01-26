class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int minDiff= Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            minDiff=Math.min(minDiff,Math.abs(arr[i+1]-arr[i]));
        }
        List<List<Integer>> ll= new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i+1]-arr[i])==minDiff){
                ll.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return ll;
    }
}