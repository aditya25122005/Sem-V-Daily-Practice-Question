class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int []A:items1){
            int key=A[0];
            map.put(key,A[1]);
        }
        for(int[]A:items2){
            if(!map.containsKey(A[0])){
                map.put(A[0],A[1]);
            }
            else{
                int old=map.get(A[0]);
                map.put(A[0],A[1]+old);
            }
        }
        List<List<Integer>> ll= new ArrayList<>();
        for(int key:map.keySet()){
            List<Integer> inner= new ArrayList<>();
            inner.add(key);
            inner.add(map.get(key));
            ll.add(new ArrayList<>(inner));
        }
        Collections.sort(ll,(a,b)->a.get(0)-b.get(0));
        return ll;
        // int [][] ans= new int[map.size()][2];
        // int idx=0;
        // for(int key:map.keySet()){
        //     ans[idx++]= new int[]{key,map.get(key)};
        // }
        // Arrays.sort(ans,(a,b)->a[0]-b[0]);
        // return ans;
    }
}