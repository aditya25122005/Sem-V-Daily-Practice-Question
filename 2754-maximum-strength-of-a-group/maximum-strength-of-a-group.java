class Solution {
    public long maxStrength(int[] nums) {
        PriorityQueue<Integer> neg = new PriorityQueue<>();
        PriorityQueue<Integer> pos = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int largest = Integer.MIN_VALUE;
        for(int num: nums){
            largest = Math.max(largest,num);
            if(num<0){
                neg.add(num);
            }
            if(num>0){
                pos.add(num);
            }
        }
        long res=1;
        boolean calculated = false;
        while(!pos.isEmpty()){
            res*= pos.poll();
            calculated=true;
        }
        while(neg.size()>=2){
            int a= -neg.poll();
            int b= -neg.poll();
            res*= a*b;
            calculated=true;
        }
        if(!calculated) return largest;
        return Math.max(res,largest);

    }
}