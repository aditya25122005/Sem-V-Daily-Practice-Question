class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        Queue<String> q= new LinkedList<>();
        HashSet<String> visited= new HashSet<>();
        int count=1;
        q.add(begin);
        while(!q.isEmpty()){
            // ek level par kitne contenders hai -> Jinka 1 character different hai 1 sath pop
            int size= q.size();
            for(int i=0;i<size;i++){
                String rm= q.poll();
                if(visited.contains(rm)) continue;
                visited.add(rm);

                if(rm.equals(end)){
                    return count;
                }
            
                for(String str:wordList){
                    if(!visited.contains(str) && canBe(str,rm)){
                        q.add(str);
                    }
                }
            }
            count++;
        }
        return 0;

    }
    public static boolean canBe(String s1, String s2){
        char[] a1= s1.toCharArray();
        char[] a2= s2.toCharArray();
        int diff=0;
        for(int i=0;i<a1.length;i++){
            if(a1[i]!=a2[i]){
                diff++;
                if(diff>1) return false;
            }
        }
        return true;
    }
}