class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        ll= new ArrayList<>();
        Trie t= new Trie();
        for(String s:words){
            t.insert(s);
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(t.root.child.containsKey(board[i][j])){
                    t.Search(board,i,j,t.root);
                }
            }
        }
        return ll;
    }
    static List<String> ll;
    static class Trie{
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
        public static void Search(char[][] board, int i, int j, Node node){
            if(i<0 || j<0 || i>=board.length || j>=board[0].length || !node.child.containsKey(board[i][j])){
                return;
            }
            char old= board[i][j];
            node= node.child.get(old);
            if(node.isTerminal!=null){
                ll.add(node.isTerminal);
                node.isTerminal=null; // 1 terminal se 1 hi word banega
            }
            board[i][j]='*';
            Search(board, i+1, j, node);
            Search(board, i-1, j, node);
            Search(board, i, j+1, node);
            Search(board, i, j-1, node);
            board[i][j]=old;

        }
    }
}