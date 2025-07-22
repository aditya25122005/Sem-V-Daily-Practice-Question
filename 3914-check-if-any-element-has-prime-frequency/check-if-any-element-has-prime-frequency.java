class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key:map.keySet()){
            int freq=map.get(key);
            if(isPrime(freq)==true) return true;
        }
        return false;

    }
    public boolean isPrime(int num){
        if(num<=1) return false;
        int count=0;
        for(int i=2;i<=Math.pow(num,0.5);i++){
            if(num%i==0) count++;
        }
        if(count!=0) return false;
        return true;
    }
}