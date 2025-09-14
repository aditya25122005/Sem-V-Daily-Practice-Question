class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String,Integer> map= new HashMap<>();
        for(int i=0;i<senders.length;i++){
            String s=messages[i];
            int words=s.split(" ").length;
            map.put(senders[i],map.getOrDefault(senders[i],0)+words);
        }
        int maxV=0;
        String ans="";
        for(String sender:map.keySet()){
            int c= map.get(sender);
            if(c>maxV){
                maxV=c;
                ans=sender;
            }else if(c==maxV && sender.compareTo(ans)>0){
                ans=sender;
            }
        }
        return ans;
    }
}