class Solution {
    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> ll= new ArrayList<>();
        for(int i=0;i<restaurants.length;i++){
            int [] A=restaurants[i];
            if(veganFriendly==1){
                if(A[2]==1 && A[3]<=maxPrice && A[4]<=maxDistance){
                ll.add(i);
                }
            }    
            else{
                if(A[3]<=maxPrice && A[4]<=maxDistance){
                ll.add(i);
                }
            }
            
            
        }
        Collections.sort(ll,(a,b)->{
            int i=restaurants[a][1];
            int j=restaurants[b][1];
            if(i!=j) return j-i;

            int id1= restaurants[a][0];
            int id2= restaurants[b][0];
            return id2-id1;
        });

        List<Integer> ans= new ArrayList<>();
        for(int i=0;i<ll.size();i++){
            ans.add(restaurants[ll.get(i)][0]);
        }
        return ans;
        
    }
}