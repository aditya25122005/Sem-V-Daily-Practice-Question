class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ll= new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();
        for(int num:nums) set.add(num);
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)) ll.add(i);
        }
        return ll;
    }
}