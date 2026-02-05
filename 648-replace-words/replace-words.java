class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie t= new Trie();
        for(String s: dict){
            t.insert(s);
        }
        String [] words= sentence.split(" ");
        StringBuilder sb= new StringBuilder();
        for(String word: words){
            sb.append(t.search(word));
            sb.append(" ");
        }
        String res = sb.toString();
        return res.substring(0,res.length()-1);
    }
    class Trie{
        class Node{
            char ch;
            String  isTerminal; // null or if Node is terminal it returns the string
            HashMap<Character,Node> child;
        

        public Node(char ch){
            this.ch=ch;
            child= new HashMap<>();
        }
        }
        private Node root= new Node('*');

        public void insert(String word) {
        Node curr= root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr= curr.child.get(ch); 
                // curr.count++;
            }
            else{

                Node nn= new Node(ch);
                curr.child.put(ch, nn);
                curr=nn;
            }
        }
        curr.isTerminal=word;
        }
        public String search(String word){
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch= word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr= curr.child.get(ch);
                if(curr.isTerminal!=null){
                    return curr.isTerminal;
                }
            }
            else{
                return word;
            }
        }
        return word;
    }
    }
    


}