class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        List<Integer> keys = new ArrayList<>();
        for(int key: map.keySet()){
            keys.add(key);
        }
        Collections.sort(keys,(a,b)->Integer.compare(map.get(b), map.get(a)));
        int [] arr = new int[k];
        for(int i=0;i<arr.length;i++){
            arr[i] = keys.get(i);
        }
        return arr;
    }
}