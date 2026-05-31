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
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer,List<Pair>> map = new TreeMap<>();
        q.add(new Pair(root,0,0));
        while(!q.isEmpty()){
            Pair rm = q.poll();
            if(!map.containsKey(rm.v)){
                map.put(rm.v, new ArrayList<>());
            }
            map.get(rm.v).add(rm);
            if(rm.root.left!=null){
                q.add(new Pair(rm.root.left, rm.l+1, rm.v-1));
            }
            if(rm.root.right!=null){
                q.add(new Pair(rm.root.right, rm.l+1, rm.v+1));
            }
        }

        for(Integer key: map.keySet()){
            List<Pair> ll = map.get(key);
            Collections.sort(ll,new Comparator<Pair>(){
                @Override
                public int compare(Pair p1, Pair p2){
                    if(p1.l==p2.l){
                        return p1.root.val-p2.root.val;
                    }
                    return p1.l-p2.l;
                }
            });
            List<Integer> curr = new ArrayList<>();
            for(Pair p: ll){
                curr.add(p.root.val);
            }
            ans.add(curr);
        }
        return ans;
        
    }
    class Pair{
        TreeNode root;
        int l;
        int v;
        public Pair(TreeNode root, int l, int v){
            this.root= root;
            this.l = l;
            this.v = v;

        }
    }
}