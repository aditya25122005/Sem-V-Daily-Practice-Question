class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        int Total=0;
        int c=0;
        for(int i=0;i<courses.length;i++){
            int dura= courses[i][0];
            int end= courses[i][1];

            Total+=dura;
            pq.add(dura);
            if(Total<=end){
                c++;
            }
            else{
                Total-=pq.poll();
                // c--;
            }

        }
        return c;
    }
}