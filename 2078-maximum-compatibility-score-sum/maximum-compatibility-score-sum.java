class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n= mentors.length;
        boolean[] taken= new boolean[n];
        max=0;
        Solve(students,mentors, 0,taken,0);
        return max;
        
    }
    static int max;
    public static void Solve(int [][] students, int [][] mentors, int idx, boolean [] taken, int score){
        if(idx==mentors.length){
            max=Math.max(max,score);
            return;
        }

        int [] s= students[idx];
        for(int k=0;k<mentors.length;k++){
            if(!taken[k]){
                int [] m= mentors[k];
                int curr=0;
                for(int i=0;i<m.length;i++){
                    if(s[i]==m[i]) curr++;
                }
                taken[k]=true;
                Solve(students,mentors,idx+1,taken, score+curr);
                taken[k]=false;
            }
        }
    }
}