class Solution {
    public long perfectPairs(int[] nums) {
        Integer [] arr= new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            arr[i]=nums[i];
        }
        Arrays.sort(arr,(a,b)->Integer.compare(Math.abs(a),Math.abs(b)));

        int i=0;
        int j=1;
        long c=0;
        while(i<arr.length){
            while(j<arr.length && Math.abs(arr[j])<=2*Math.abs(arr[i])){
                j++;
            }
            c+= j-i-1;
            i++;
        }
        return c;
    }
}