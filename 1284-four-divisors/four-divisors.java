class Solution {
    public int sumFourDivisors(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();

        int ans=0;
        for(int num:nums){

            if(map.containsKey(num)){
                ans+= map.get(num);
                continue;
            }
            int c=2;
            int curr=1+num;
            for(int i=2;i*i<=num;i++){
                int j= num/i;
            if(num%i==0){
                if(i==j){
                    c++;
                    curr+=i;
                }
                else{
                    c+=2;
                    curr+= i;
                    curr += j;
                }

                if(c>4){
                    break;
                }
            }
                
            }
            if(c==4){
            ans+= curr;
            map.put(num,curr);
            }
        }
        return ans;
    }
}