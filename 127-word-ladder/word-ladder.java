class Solution {
   public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        Queue<Pair> q= new LinkedList<>();
        HashSet<String> visited= new HashSet<>();
        int ans=Integer.MAX_VALUE;
        int curr=0;
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()){
            int size= q.size();
            boolean find=false;
            
            for(int i=0;i<size;i++){
                Pair rm = q.poll();
                String str= rm.s;
                int dis=rm.dis;

                if(visited.contains(str)){
                    continue;
                }
                visited.add(str);
                 
                if(str.equals(endWord)){
                    find=true;
                    //ans=Math.min(ans,dis);
                    //break;
                }

                for(String nbrs:wordList){
                    if(!visited.contains(nbrs) && isOk(str, nbrs)){
                        q.add(new Pair(nbrs,dis+1));
                    }
                }
            }
            curr++;
            if(find){
                ans=Math.min(ans,curr);
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;

    }
    public static boolean isOk(String s1, String s2){
        char[] a= s1.toCharArray();
        char[] b= s2.toCharArray();
        // Arrays.sort(a);
        // Arrays.sort(b);
        int diff=0;
        for(int i=0;i<a.length;i++){
            if(a[i]!=b[i]){
                diff++;
                if(diff>1) return false;
            }
        }
        if(diff>1) return false;
        return true;

    }
    static class Pair{
        String s;
        int dis;
        public Pair(String s, int dis){
            this.s=s;
            this.dis=dis;
        }

    }

    
}