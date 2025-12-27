class Solution {
    public int smallestAbsent(int[] nums) {
        int avg=0;
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            avg+=num;
            set.add(num);
        }
        avg = avg/nums.length;
        int ans=avg+1;
        if(ans<=0){
            ans=1;
        }
        while(set.contains(ans)){
            ans++;
        }
        return ans;
    }
}