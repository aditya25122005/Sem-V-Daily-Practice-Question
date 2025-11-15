class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,List<Integer>> row= new HashMap<>(); // for each row
        HashMap<Integer,List<Integer>> col= new HashMap<>(); // for each col
        
        for(int[]A:buildings){
            int r= A[0];
            int c= A[1];

            if(!row.containsKey(r)){
                row.put(r,new ArrayList<>(Arrays.asList(c,c)));
            }
            else{
                int newMinC=Math.min(row.get(r).get(0),c);
                int newMaxC=Math.max(row.get(r).get(1),c);
                row.put(r,new ArrayList<>(Arrays.asList(newMinC,newMaxC)));
            }

            if(!col.containsKey(c)){
                col.put(c,new ArrayList<>(Arrays.asList(r,r)));
            }
            else{
                int newMinR=Math.min(col.get(c).get(0),r);
                int newMaxR=Math.max(col.get(c).get(1),r);
                col.put(c,new ArrayList<>(Arrays.asList(newMinR,newMaxR)));
            }

        }
        int cnt=0;

        for(int[] B:buildings){
            int x=B[0];
            int y=B[1];
            if(x>col.get(y).get(0) && x<col.get(y).get(1) && 
            y>row.get(x).get(0) && y<row.get(x).get(1)){
                cnt++;
            }
        }
        return cnt;


    }
}