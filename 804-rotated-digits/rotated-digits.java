class Solution {
    public int rotatedDigits(int n) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        map.put(2,5);
        map.put(3,null);
        map.put(4,null);
        map.put(5,2);
        map.put(6,9);
        map.put(7,null);
        map.put(8,8);
        map.put(9,6);
        int count=0;
        for(int i=1;i<=n;i++){
            int num=i;
            StringBuilder sb= new StringBuilder();

            boolean isGood=true;
            while(num>0){
                int digit=num%10;
                if(map.get(digit)==null){
                    isGood=false;
                    break;
                }
                else{
                    sb.append(map.get(digit));
                }
                num/=10;
            }

            if(isGood){
                 int n2=Integer.parseInt(sb.reverse().toString());
                 if(n2!=i) count++;
            }
        }
        return count;
    }
}