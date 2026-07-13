class Solution {
    int lo;
    public List<Integer> sequentialDigits(int low, int high) {
        lo=low;
        List<Integer> ans = new ArrayList<>();
        for(int start=1;start<=9;start++){
            generate(ans,start,high);
        }
       
        System.out.println(ans);
        Collections.sort(ans);
        return ans;


    }
    public void generate(List<Integer> ll, int curr, int limit){
        if(curr>limit){
            return;
        }
        if(curr>=lo && curr<=limit)
        ll.add(curr);
        int last = curr%10;
        if(last!=9){
            curr = curr*10 + (last+1);
            generate(ll,curr,limit);
        }
        
        // ll.remove(ll.size()-1);

    }
}