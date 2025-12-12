class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        for(int i=0;i<quiet.length;i++){
            map.put(i, new ArrayList<>());
        }
        int[] in= new int[quiet.length];
        for(int[] A:richer){
            int rich=A[0];
            int poor= A[1];
            map.get(rich).add(poor);
            in[poor]++;
        }
        Queue<Integer> q= new LinkedList<>();
        int[] ans= new int[quiet.length];
        for(int i=0;i<ans.length;i++){
            ans[i]=i;
        }
        for(int i=0;i<in.length;i++){
            if(in[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int Rich=q.poll();
            for(int poor:map.get(Rich)){
                if(quiet[ans[Rich]] < quiet[ans[poor]]){
                    ans[poor]=ans[Rich];
                }
                in[poor]--;
                if(in[poor]==0){
                    q.add(poor);
                }
            }
        }
        return ans;

    }
}