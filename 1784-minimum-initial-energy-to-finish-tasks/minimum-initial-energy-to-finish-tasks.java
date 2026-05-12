class Solution {
    public int minimumEffort(int[][] tasks) {
        int sum = 0;
        for(int [] arr: tasks){
            sum+= arr[0];
        }
        Arrays.sort(tasks,(a,b)->Integer.compare(b[1]-b[0], a[1]-a[0]));
        int curr = sum;
        for(int [] arr: tasks){
            if(curr>= arr[1]){
                curr -= arr[0];
            }
            else if(curr<arr[1]){
                int diff= arr[1]-curr;
                curr+= diff;
                sum+= diff;
                curr-= arr[0];
            }
        }
        return sum;
    }
    // sum -> 31->32
    // 21
    // 11
    // 3
    // -> 4- 2=2
    // 2
    

}