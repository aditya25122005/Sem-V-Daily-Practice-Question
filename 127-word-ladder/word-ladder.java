class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> pq= new LinkedList<>();
        HashSet<String> visited= new HashSet<>();
        int ans=Integer.MAX_VALUE;
        int curr=1;
        pq.add(beginWord);
        while(!pq.isEmpty()){
            int size= pq.size();
            for(int i=0;i<size;i++){
                String rm= pq.poll();
                if(visited.contains(rm)){
                    continue;
                }
                visited.add(rm);
                if(rm.equals(endWord)){
                    ans=Math.min(ans,curr);
                    // break;
                }
                for(String nbrs: wordList){
                    if(isValid(rm,nbrs) && !visited.contains(nbrs)){
                        pq.add(nbrs);
                    }
                }

            }
            curr++;
            

        }
        return ans==Integer.MAX_VALUE? 0: ans;
    }
    public static boolean isValid(String a, String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                diff++;
                if(diff==2) return false;
            }
        }
        return diff==1;
    }
    static class Pair{
        String word;
        int cost;
        public Pair(String word, int cost){
            this.word=word;
            this.cost=cost;
        }
    }
}