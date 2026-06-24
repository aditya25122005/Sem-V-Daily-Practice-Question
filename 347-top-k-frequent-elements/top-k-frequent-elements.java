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
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(a.freq,b.freq));
        for(int key: map.keySet()){
            int val = key;
            int freq = map.get(key);
            pq.add(new Pair(val,freq));
            if(pq.size()>k) pq.poll();
        }
        int[] arr = new int[k];
        int idx = 0;
        while(k>0){
            arr[idx++] = pq.poll().val;
            k--;
        }
        return arr;


    }
    static class Pair{
        int val;
        int freq;
        public Pair(int val, int freq){
            this.val=val;
            this.freq = freq;
        }
    }
}