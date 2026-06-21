class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int num: costs){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int [] arr = new int[max+1];
        for(int num: costs){
            arr[num]++;
        }
        int [] arr2= new int[n];
        int idx = 0;
        for(int i=0;i<arr.length;i++){
            int val = arr[i];
            while(val!=0){
                arr2[idx++] = i;
                val--;
            }
        }
        int ans = 0;
        for(int i=0;i<arr2.length;i++){
            if(arr2[i]<=coins){
                ans++;
                coins-=arr2[i];
            }
            else{
                break;
            }
        }
        return ans;
    }
}