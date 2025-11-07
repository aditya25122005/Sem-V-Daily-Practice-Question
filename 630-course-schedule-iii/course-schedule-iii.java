class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->a[1]-b[1]);
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        int total_time=0;
        int c=0;
        for(int i=0;i<courses.length;i++){
            int duration=courses[i][0];
            int deadline=courses[i][1];
            total_time += duration;
            pq.add(duration);
            if(total_time<=deadline){
                c++;
            }
            else{
                int rm=pq.poll();
                total_time-=rm;
            }
        }
        return c;
    }
}