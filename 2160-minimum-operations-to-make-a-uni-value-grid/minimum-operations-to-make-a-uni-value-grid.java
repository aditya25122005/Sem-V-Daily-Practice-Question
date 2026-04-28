class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> ll= new ArrayList<>();
        for(int [] A: grid){
            for(int num: A){
                ll.add(num);
            }
        }
        Collections.sort(ll);
        int lo= 0;
        int hi= ll.size()-1;
        int mid=(lo+hi)/2;
        int target = ll.get(mid);
        int prev = ll.get(0)%x;
        for(int num: ll){
            if(num%x!= prev) return -1;
        }
        int ans = 0;
        for(int num: ll){
            if(num<target){
                ans+= (target-num)/x;
            }
            else if(num>target){
                ans+= (num-target)/x;
            }
        }
        System.out.println(target);
        return ans;

    }
}