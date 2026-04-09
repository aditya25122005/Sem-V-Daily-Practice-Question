class Solution {
    public int removeDuplicates(int[] nums) {
        // HashSet<Integer> hh = new HashSet<>();

        // int j=0;
        // for(int i=0;i<nums.length;i++){
        //     if(!hh.contains(nums[i])){
        //         hh.add(nums[i]);
        //         nums[j++]= nums[i];
        //     }
            
        // }
        // return j;

        int j=1;
        int i=1;
        while(i<nums.length){
            while(i<nums.length && nums[i]==nums[i-1]){
                i++;
            }
            if(i<nums.length){
                nums[j++]= nums[i];
                i++;
            }
        }
        return j;
    }
}