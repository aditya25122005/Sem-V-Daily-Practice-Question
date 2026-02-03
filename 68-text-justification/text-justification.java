class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ll= new ArrayList<>();
        Queue<String> q= new LinkedList<>();
        int curr=0;
        for(String str:words){
            if(curr+str.length()+q.size() <=maxWidth){
                curr+=str.length();
                q.add(str);
            }
            else{
                StringBuilder sb= new StringBuilder();
                int wordsCount = q.size();
                int gaps= wordsCount-1;
                if(gaps==0){ // single word
                    sb.append(q.poll());
                    while(sb.length()< maxWidth){
                        sb.append(" ");
                    }
                    ll.add(sb.toString());
                    q.clear();
                    q.add(str);
                    curr=str.length();
                    continue;
                    // break;
                }

                int totalSpace= maxWidth-curr;
                int perGapSpace= totalSpace/gaps;
                int extraSpace = totalSpace%gaps;
                while(!q.isEmpty()){
                    sb.append(q.poll());
                    
                    if(!q.isEmpty()){
                        for(int i=0;i<perGapSpace;i++){
                            sb.append(" ");
                        }
                        if(extraSpace>0){
                            sb.append(" ");
                            extraSpace--;
                        }
                    }
                }
                ll.add(sb.toString());
                q.clear();
                q.add(str);
                curr= str.length();
            }
        }
        
        StringBuilder sb= new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.poll());
            if(!q.isEmpty()) sb.append(" ");
        }
        while(sb.length()<maxWidth){
            sb.append(" ");
        }
        ll.add(sb.toString());

        return ll;
    }
}