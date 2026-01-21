class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer,Integer> map1= new HashMap<>();
        int n= nums1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int curr= nums1[i]+nums2[j];
                map1.put(curr,map1.getOrDefault(curr,0)+1);
            }
        }
        HashMap<Integer,Integer> map2= new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
            int curr= nums3[i]+nums4[j];
            map2.put(curr,map2.getOrDefault(curr,0)+1);
            }
        }
        int count=0;

        for(int key: map1.keySet()){
            if(map2.containsKey(-key)){
                int c1= map1.get(key);
                int c2= map2.get(-key);
                count+= c1*c2;
            }
        }
        return count;
    }
}