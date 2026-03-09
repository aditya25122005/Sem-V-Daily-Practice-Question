class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        HashMap<Integer,int[]> ind= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int num= nums[i];
            if(!map.containsKey(num)){
                ind.put(num, new int[2]);
                ind.get(num)[0]=i;
                ind.get(num)[1]=i;
            }
            else{
                ind.get(num)[1]=i;
            }
            map.put(num,map.getOrDefault(num,0)+1);

        }
        List<Integer> ll= new ArrayList<>();
        int maxF=0;
        for(int key: map.keySet()){
            int f= map.get(key);
            maxF=Math.max(maxF,f);
        }

        for(int key:map.keySet()){
            if(map.get(key)==maxF){
                ll.add(key);
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int k: ll){
            int first = ind.get(k)[0];
            int last = ind.get(k)[1];
            ans=Math.min(ans,last-first+1);
        }
        return ans;



    }
}