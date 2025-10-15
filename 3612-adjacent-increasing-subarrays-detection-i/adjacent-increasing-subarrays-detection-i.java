class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
       if(nums.size()<2*k) return false;
        for(int i=0;i<=nums.size()-2*k;i++){
            boolean first=true;
            for(int j=i+1;j<i+k;j++){
                if(nums.get(j)<=nums.get(j-1)){
                    first=false;
                    break;
                }
            }
            if(!first) continue;
            boolean second=true;
            for(int j=i+k+1; j<2*k+i;j++){
                if(nums.get(j)<=nums.get(j-1)){
                    second=false;
                    break;
                }
            }
            if(second) return true;
            
        }
        return false;
    }
}