class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> ll = new ArrayList<>();
        for(int num: nums){
            String s = String.valueOf(num);
            for(char ch: s.toCharArray()){
                ll.add(ch-'0');
            }
        }
        int [] ans = new int[ll.size()];
        for(int i=0;i<ll.size();i++){
            ans[i] = ll.get(i);
        }
        return ans;
    }
}