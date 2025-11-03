class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ll= new ArrayList<>();
        HashSet<Integer> set= new HashSet<>();
        int small=Integer.MAX_VALUE;
        int large=Integer.MIN_VALUE;
        for(int num:nums) {
            set.add(num);
            small=Math.min(small,num);
            large=Math.max(large,num);
        }
        for(int i=small; i<=large;i++){
            if(!set.contains(i)) ll.add(i);
        }
        return ll;

    }
}