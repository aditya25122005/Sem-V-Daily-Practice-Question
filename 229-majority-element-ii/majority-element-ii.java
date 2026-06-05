class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int n1 = 0;
        int n2 = 0;
        int c1=0;
        int c2 = 0;
        for(int num:nums){
            if(num==n1){
                c1++;
            }
            else if(num==n2){
                c2++;
            }
            else if(c1==0){
                n1 = num;
                c1++;
            }
            else if(c2==0){
                n2 = num;
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for(int num: nums){
            if(num==n1){
                c1++;
            }
            else if(num==n2){
                c2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(c1>n/3){
            res.add(n1);
        }
        if(c2>n/3){
            res.add(n2);
        }
        return res;
    }
}