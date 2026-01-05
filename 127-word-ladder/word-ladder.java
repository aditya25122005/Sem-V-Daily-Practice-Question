class Solution {
    public int ladderLength(String begin, String end, List<String> wordList) {
        if(!wordList.contains(end)) return 0;
        Queue<String> q= new LinkedList<>();
        HashSet<String> visited= new HashSet<>();
        q.add(begin);
        int count=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int s=0;s<size;s++){
                String rm= q.poll();

                if(visited.contains(rm)){
                    continue;
                }
                visited.add(rm);
                if(rm.equals(end)){
                    return count;
                }
                for(String s2:wordList){
                    if(isValid(rm,s2) && !visited.contains(s2)){
                        q.add(s2);
                    }
                }

            }
            count++;

        }
        return 0;
    }
    public static boolean isValid(String s1, String s2){
        boolean NotEqual=false;
        int count=0;
        for(int i=0;i<s1.length();i++){

            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                if(count>1) return false;
            }
        }
        if(count==1) return true;
        return false;
    }
}