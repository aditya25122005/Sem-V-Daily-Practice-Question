class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int [] comp= new int[n];
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1]<=maxDiff){
                comp[i]=comp[i-1];
            }
            else{
                comp[i]=comp[i-1]+1;
            }
        }
        boolean [] res= new boolean [queries.length];
        int idx=0;
        for(int []Q:queries){
            int u=Q[0];
            int v=Q[1];
            res[idx++] = (comp[u]==comp[v]);
        }
        return res;
        // HashMap<Integer,List<Integer>> map= new HashMap<>();
        // for(int i=0;i<n;i++){
        //     map.put(i, new ArrayList<>());
        // }
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(Math.abs(nums[i]-nums[j])<=maxDiff){
        //             map.get(i).add(j);
        //             map.get(j).add(i);
        //         }
        //     }
        // }

        // int [][] arr= new int [n][2];
        // for(int i=0;i<n;i++){
        //     arr[i][0]= nums[i]; // value
        //     arr[i][1]=i; // idx
        // }
        // Arrays.sort(arr,(a,b)->a[0]-b[0]);
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(arr[j][0]-arr[i][0]> maxDiff) break;
        //         int u= arr[i][1];
        //         int v= arr[j][1];
        //         map.get(u).add(v);
        //         map.get(v).add(u);
        //     }
        // }
        // boolean [] res= new boolean[queries.length];

        // int [] component= new int [n];
        // Arrays.fill(component,-1);
        // int cid=0;
        // for(int i=0;i<n;i++){
        //     if(component[i]!=-1 ) continue;

        //     Queue<Integer> q= new LinkedList<>();
        //     q.add(i);
        //     component[i]=cid;
        //     while(!q.isEmpty()){
        //         int rm= q.poll();
        //         for(int nbrs: map.get(rm)){
        //             if(component[nbrs]==-1){
        //                 component[nbrs]=cid;
        //                 q.add(nbrs);
        //             }
        //         }
        //     }
        //     cid++;
        // }

        // int idx=0;
        // for(int [] Q:queries){
        //     int u=Q[0];
        //     int v= Q[1];
        //     res[idx++] = component[u]==component[v];
            
        // }
        // return res;
        // int idx=0;

        // for(int [] Q: queries){
        //     int src= Q[0];
        //     int des= Q[1];

        //     Queue<Integer> q= new LinkedList<>();
        //     HashSet<Integer> visited= new HashSet<>();
        //     q.add(src);
        //     boolean isTrue=false;
        //     while(!q.isEmpty()){
        //         int rm= q.poll();
        //         if(visited.contains(rm)) continue;
        //         visited.add(rm);
        //         if(rm==des){
        //             res[idx]=true;
        //             isTrue=true;
        //             idx++;
        //             break;
        //         }
        //         for(int nbrs: map.get(rm)){
        //             if(!visited.contains(nbrs)){
        //                 q.add(nbrs);
        //             }
        //         }
        //     }
        //     if(!isTrue){
        //         idx++;
        //     }
            

        // }
        // return res;

    }
}