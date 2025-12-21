class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ll= new ArrayList<>();
        int i=0;
        while(i<nums.length){
            int correct=nums[i]-1;
            if(nums[i]!=nums[correct]){
                int temp=nums[i];
                nums[i]=nums[correct];
                nums[correct]=temp;
            }
            else{
                i++;
            }
        }
       
        for(int idx=0;idx<nums.length;idx++){
            if(nums[idx]!=idx+1){
                ll.add(idx+1);
            }
        }
        // //-> 7,3,2,4,8,2,3,1
        // temp=3, 
        // //-> 7,2,3,4,8,2,3,1
        // temp=8, 

        // HashSet<Integer> set= new HashSet<>();
        // for(int num:nums) set.add(num);
        // for(int i=1;i<=nums.length;i++){
        //     if(!set.contains(i)) ll.add(i);
        // }
        return ll;
    }
}