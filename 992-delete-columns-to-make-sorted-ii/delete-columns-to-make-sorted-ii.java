class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();
        boolean [] already=new boolean[n-1];

        int delete=0;
        for(int col=0;col<m;col++){
            boolean deleteThis=false;
            for(int row=0;row<n-1;row++){
                if(!already[row] && strs[row].charAt(col) > strs[row+1].charAt(col)){
                    deleteThis=true;
                    break;
                }
            }
            if(deleteThis){
                delete++;
                continue;
                // Ye column delete ho gaya ye Next column ki koi help nah kar paega 
            }

            for(int row=0;row<n-1;row++){
                if(!already[row] && strs[row].charAt(col)<strs[row+1].charAt(col)){
                    already[row] = true; // this will help in next column (for this same row)
                }
            }

        }
        return delete;
    }
}