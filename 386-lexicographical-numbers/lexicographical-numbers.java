class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ll = new ArrayList<>();
        Solve(n,ll,0);
        ll.remove(0);
        return ll;

    }
    public static void Solve(int n, List<Integer> ll, int curr){
        if(curr>n){
            return;
        }

        ll.add(curr);

        int i=1;
        if(curr>0){
            i=0;
        }
        for(;i<=9;i++){
            Solve(n,ll,curr*10 +i);
        }
        

    }
}