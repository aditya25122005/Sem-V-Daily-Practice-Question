class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n=nums.length;
        List<String> ll= new ArrayList<>();
        int si=0;
        for(int i=0;i<nums.length-1;i++){
            
            if(nums[i+1]!=nums[i]+1){
                if(si==i){
                    ll.add(String.valueOf(nums[i]));
                    si=i+1;
                    // continue;
                }
                else{
                StringBuilder sb= new StringBuilder();
                sb.append(nums[si]);
                sb.append("->");
                sb.append(nums[i]);
                ll.add(sb.toString());

                si=i+1;
                }
            }

        }
        if(nums.length>0){
            if(si==nums.length-1){
                ll.add(String.valueOf(nums[n-1]));
            }
            else{
                StringBuilder sb= new StringBuilder();
                sb.append(nums[si]);
                sb.append("->");
                sb.append(nums[n-1]);
                ll.add(sb.toString());
            }
        }
        return ll;
    }
}