class Solution {
    public int findChampion(int[][] grid) {
        // int champion=0;
        // HashSet<Integer> loser= new HashSet<>();
        // for(int i=0;i<grid.length;i++){
        //     for(int j=0;j<grid.length;j++){
        //         if(i==j) continue;
        //         if(grid[i][j]==1){
        //             loser.add(j);
        //         }

        //     }
        // }
        // for(int i=0;i<grid.length;i++){
        //     if(!loser.contains(i)){
        //         return i;
        //     }
        // }
        // return 0;

        int champion=0;
        for(int i=0;i<grid.length;i++){
            if(i==champion) continue;
            if(grid[champion][i]==0){
                champion=i;
            }
        }
        return champion;
    }
}