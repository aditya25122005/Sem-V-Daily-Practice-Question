class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ll= new ArrayList<>();
        Solve(num,ll,0);
        return ll;
    }
    public static boolean Solve(String s, List<Integer> ll, int idx){
        if(idx>=s.length()){
            return ll.size()>=3;
        }
        long num=0;
        for(int i=idx;i<s.length();i++){

            if(s.charAt(idx)=='0' && i>idx){ // means starts with '0' and length is more than 1
                break;
            }
            num= num*10 + (s.charAt(i)-'0');
            if(num>Integer.MAX_VALUE) return false;

            int curr=(int)num;
            int size=ll.size();
            if(size>=2){
                if(curr > ll.get(size-1)+ll.get(size-2)) break;
                if(curr < ll.get(size-1)+ll.get(size-2)) continue;
            }
            ll.add(curr);
            if(Solve(s,ll,i+1)) return true;
            ll.remove(ll.size()-1);
        }
        return false;
    }
}