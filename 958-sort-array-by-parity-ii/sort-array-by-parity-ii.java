class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int n= nums.length;
        int [] ans= new int[nums.length];
        Stack<Integer> odd= new Stack<>();
        Stack<Integer> even= new Stack<>();
        for(int num:nums){
            if(num%2==0) even.push(num);
            else{
                odd.push(num);
            }
        }
        for(int i=0;i<n;i++){
            if(i%2==0){
                ans[i]=even.pop();
            }else{
                ans[i]= odd.pop();
            }
        }
        return ans;

    }
}