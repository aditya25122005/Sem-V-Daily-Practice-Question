/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,List<Pair>> map = new TreeMap<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair rm = q.poll();
            int r = rm.r;
            int c = rm.c;
            if(!map.containsKey(rm.c)){
                map.put(rm.c, new ArrayList<>());
            }
            map.get(rm.c).add(new Pair(rm.node,r,c));
            if(rm.node.left!=null){
                q.add(new Pair(rm.node.left,r+1,c-1));
            }
            if(rm.node.right!=null){
                q.add(new Pair(rm.node.right,r+1,c+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int key: map.keySet()){
            List<Pair> ll = map.get(key);
            Collections.sort(ll,(a,b)->{
                if(a.r == b.r){
                    return a.node.val-b.node.val;
                }
                return a.r - b.r;
            });
            List<Integer> inner = new ArrayList<>();
            for(Pair p: ll){
                inner.add(p.node.val);
            }
            ans.add(new ArrayList<>(inner));
        }
        return ans;
    }
    static class Pair{
        TreeNode node;
        int r;
        int c;
        public Pair(TreeNode node, int r, int c){
            this.node = node;
            this.r = r;
            this.c = c;
        }
    }
}