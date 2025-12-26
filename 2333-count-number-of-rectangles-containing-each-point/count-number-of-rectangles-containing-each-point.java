class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        int [] ans= new int[points.length];
        HashMap<Integer,List<Integer>> map= new HashMap<>();
        int maxH=0;
        for(int []A:rectangles){
        int l=A[0];
        int h=A[1];
        maxH=Math.max(maxH,h);
        if(!map.containsKey(h)){
            map.put(h,new ArrayList<>());
        }
        map.get(h).add(l);
        }
        for(List<Integer> ll:map.values()) Collections.sort(ll);


        int idx=0; // for ans;
        for(int [] p:points){
            int c=0;
            int l=p[0];
            int h=p[1];

            for(int i=h;i<=maxH;i++){
                if(map.containsKey(i)){
                    List<Integer> ll= map.get(i);
                    // 'i' height par all lengths ke squares are prsent in ll.
                    c+=ll.size()- find(l,ll); // point ki length tak , kitne rectangles hai

                }
            }
            ans[idx++] = c;
        }
        return ans;

    }
    public static int find(int len, List<Integer> ll){

        int i=0;
        int j=ll.size()-1;
        int ans=ll.size();
        while(i<=j){
            int mid=i+(j-i)/2;
            if(ll.get(mid)>=len){
                j=mid-1;
                ans=mid;
            }
            else{
                i=mid+1;
            }


        }
        return ans;
    }
}