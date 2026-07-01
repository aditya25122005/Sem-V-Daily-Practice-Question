class Solution {
    class Node{
        char ch;
        HashMap<Character,Node> map;
        boolean isTerminal = false;
        public Node(char ch){
            this.ch = ch;
            map = new HashMap<>();
        }
    }
    public String longestCommonPrefix(String[] strs) {
        Node root = new Node('*');
        // insert in trie
        for(String s: strs){
            Node curr = root;
            for(char ch: s.toCharArray()){
                if(curr.map.containsKey(ch)){
                    curr = curr.map.get(ch);
                }
                else{
                    Node nn = new Node(ch);
                    curr.map.put(ch,nn);
                    curr=nn;
                }
            }
            curr.isTerminal = true;
        }
       

        // chech trie
        StringBuilder sb = new StringBuilder();
        Node curr =root;
        while(!curr.isTerminal && curr.map.size()==1){
            char ch = '.';
            for(char key: curr.map.keySet()){
                ch=key;
                sb.append(key); // there will be only single key
            }
           
            Node next = curr.map.get(ch);
            curr = next;
        }
        return sb.toString();
    }
}