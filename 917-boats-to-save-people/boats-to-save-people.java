class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int lo=1;
        int hi=people.length;
        int ans=0;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(isOk(people,limit,mid)){
                ans=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }

        }
        return ans;
    }
    public static boolean isOk(int[] people, int limit, int boat){
        Arrays.sort(people);
        int left=0;
        int right=people.length-1;
        int boats=0;
        while(left<=right){
            if(people[left]+people[right]<=limit){
                left++;
            }
            right--;
            boats++;
        }
        return boats<=boat;
    }
}