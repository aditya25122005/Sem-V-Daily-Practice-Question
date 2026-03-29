class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n= costs.length;
        int i=0;
        int j=n-1;
        long sum=0;
        int count=0;
        PriorityQueue<Integer> front = new PriorityQueue<>();
        PriorityQueue<Integer> back= new PriorityQueue<>();


        
        while(front.size()<candidates && i<(n+1)/2){
            front.add(costs[i++]);
        }
        while(back.size()<candidates && back.size()<n/2){
            back.add(costs[j--]);
        }

        while(count<k){

            int A= front.isEmpty()? Integer.MAX_VALUE: front.peek();
            int B= back.isEmpty()? Integer.MAX_VALUE: back.peek();

            if(A<=B){
                sum+= front.poll();
                while(i<=j && front.size()<candidates){
                    front.add(costs[i++]);
                }
            }
            else if(B<A){
                sum+= back.poll();
                while(i<=j && back.size()<candidates){
                    back.add(costs[j--]);
                }
            }
            // else{

            // }
            count++;
            
        }
        return sum;


    }
}