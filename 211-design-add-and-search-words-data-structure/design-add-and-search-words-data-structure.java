class WordDictionary {
    class Node{
        char ch;
        boolean isTerminal;
        HashMap<Character,Node> child;
        public Node(char ch){
            this.ch=ch;
            child = new HashMap<>();
        }

    }
    private Node root;
    public WordDictionary() {
        root = new Node('*');
    }
    
    public void addWord(String word) {
        Node curr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.child.containsKey(ch)){
                curr = curr.child.get(ch);
            }
            else{
                Node nn = new Node(ch);
                curr.child.put(ch,nn);
                curr = nn;
            }
        }
        curr.isTerminal = true;
    }
    
    public boolean search(String word) {
       return Solve(root,word,0);
    }
    public static boolean Solve(Node curr, String word, int idx){
        if(idx==word.length()){
            return curr.isTerminal;
        }
        char ch = word.charAt(idx);
        if(ch=='.'){
            for(char nbrs : curr.child.keySet()){
                Node child = curr.child.get(nbrs);
                if(Solve(child,word, idx+1)){
                    return true;
                }
            }
            return false;
        }
        if(!curr.child.containsKey(word.charAt(idx))){
            return false;
        }
        boolean res = Solve(curr.child.get(ch),word,idx+1);
        return res;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */