class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            if(num%2==0){
                map.put(num,map.getOrDefault(num,0)+1);
            }
        }
        int ans=-1;
        int maxVal=Integer.MIN_VALUE;
        for(int key:map.keySet()){
            if(map.get(key)==maxVal){
                ans=Math.min(key,ans);
                maxVal=map.get(key);
            }else if(map.get(key)>maxVal){
                maxVal=map.get(key);
                ans=key;
            }
            
        }
        return ans;

    }
}