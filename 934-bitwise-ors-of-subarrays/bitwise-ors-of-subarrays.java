class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> res= new HashSet<>();
        HashSet<Integer> prev= new HashSet<>(); // for storing prev Or value
        
        for(int num:arr){
            HashSet<Integer> curr= new HashSet<>();
            curr.add(num);
            for(int val:prev){
                curr.add(val | num);
            }
            prev=curr;
            res.addAll(curr);
        }
        return res.size();
    }
}