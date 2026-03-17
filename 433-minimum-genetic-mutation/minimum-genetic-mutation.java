class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q= new LinkedList<>();
        HashSet<String> visited= new HashSet<>();

        q.add(startGene);
        int curr=0;
        int ans=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int size= q.size();
            boolean found=false;
            for(int i=0;i<size;i++){
                String rm=q.poll();
                if(visited.contains(rm)){
                    continue;
                }
                visited.add(rm);
                if(rm.equals(endGene)){
                    found=true;
                    ans=Math.min(ans,curr);
                    break;
                }
                for(String nbrs:bank){
                    if(!visited.contains(nbrs) && Ok(rm,nbrs)){
                        q.add(nbrs);
                    }
                }
            }
            if(found){
                ans=Math.min(ans,curr);
            }
            curr++;
            
            
        }
        return ans==Integer.MAX_VALUE? -1 : ans;

    }
    public static boolean Ok(String a, String b){
        int diff=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                diff++;
                if(diff>1) return false;
            }
        }
        return true;
    }
}