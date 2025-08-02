class Solution {
    public long minCost(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> map1= new HashMap<>();
        HashMap<Integer,Integer> map2= new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int num:arr1){
            map1.put(num,map1.getOrDefault(num,0)+1);
            min=Math.min(min,num);
        }
        for(int num:arr2){
            map2.put(num,map2.getOrDefault(num,0)+1);
            min=Math.min(min,num);
        }
        Set<Integer>keys= new HashSet<>();

        List<Integer> SWAP= new ArrayList<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        for(int key:keys){
            int sum=map1.getOrDefault(key,0)+map2.getOrDefault(key,0);
            if(sum%2!=0) return -1;
        }
        for(int key:keys){
            int f1=map1.getOrDefault(key,0);
            int f2=map2.getOrDefault(key,0);
            int diff=f1-f2;

            if(diff>0){
                for(int i=0;i<diff/2;i++){
                    SWAP.add(key);
                }
            }
            else if(diff<0){
                for(int i=0;i<-diff/2;i++){
                    SWAP.add(key);
                }
            }
        }
        Collections.sort(SWAP);
        long cost=0;
        for(int i=0;i<SWAP.size()/2;i++){
            cost+=Math.min(2*min,SWAP.get(i));
        }
        return cost;



    }
}