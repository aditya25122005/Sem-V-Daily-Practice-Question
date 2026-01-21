class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n= nums.length;
        List<List<Integer>> ll= new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;

                int lo= j+1;
                int hi=n-1;
                while(lo<hi){
                    long curr =(long) nums[i]+nums[j]+nums[lo]+nums[hi];
                    if(curr==target){
                        ll.add(Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]));
                        lo++;
                        hi--;
                        while(lo<hi && nums[lo]==nums[lo-1]) lo++;
                        while(lo<hi && nums[hi]==nums[hi+1]) hi--;
                    }
                    else if(curr<target){
                        lo++;
                        while(lo<hi && nums[lo]==nums[lo-1]) lo++;
                    }
                    else{
                        hi--;
                        while(lo<hi && nums[hi]==nums[hi+1]) hi--;
                    }
                }
            }
        }
        return ll;
    }
}