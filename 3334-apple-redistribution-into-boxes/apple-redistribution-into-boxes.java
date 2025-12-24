class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int totalA=0;
        for(int num:apple){
            totalA+=num;
        }
        int totalC=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder()); 
        for(int num:capacity){
            pq.add(num);
            totalC+=num;
        }
        int c=0;
        while(totalA>0){
            int cap=pq.poll();
            totalA-=cap;
            c++;
        }
        return c;
        
    }
}