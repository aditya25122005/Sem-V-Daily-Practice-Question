class Solution {
    public int sumFourDivisors(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        HashSet<Integer> bad= new HashSet<>();
        int ans=0;
        for(int num:nums){
            if(bad.contains(num)) continue;
            if(map.containsKey(num)){
                ans+= map.get(num);
                continue;
            }
            int c=0;
            int curr=0;
            for(int i=1;i<=num;i++){
                if(num%i==0){
                    c++;
                    curr+=i;

                    if(c>4){
                        bad.add(num);
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