/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ll = new ArrayList<>();
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        MakeGraph(map,root);
        //System.out.println(map);
        Queue<Pair> q = new LinkedList<>();
        HashSet<Integer> vis = new HashSet<>();
        q.add(new Pair(target.val, 0));
        while(!q.isEmpty()){
            Pair rm = q.poll();
            if(vis.contains(rm.vtx)) continue;
            vis.add(rm.vtx);
            if(rm.dis==k){
                ll.add(rm.vtx);
            }
            if(rm.dis>k){
                break;
            }
            for(int nbrs : map.get(rm.vtx)){
                if(!vis.contains(nbrs)){
                    q.add(new Pair(nbrs,rm.dis+1));
                }
            }
        }
        return ll;
    }
    class Pair{
        int vtx;
        int dis;
        public Pair(int vtx, int dis){
            this.vtx = vtx;
            this.dis = dis;
        }
    }
    public static void MakeGraph(HashMap<Integer,HashSet<Integer>> map, TreeNode root){
        if(root == null){
            return;
        }
        if(!map.containsKey(root.val)){
            map.put(root.val, new HashSet<>());
        }
        if(root.left!=null){
            map.get(root.val).add(root.left.val);
            if(!map.containsKey(root.left.val)){
                map.put(root.left.val, new HashSet<>());
                map.get(root.left.val).add(root.val);
            }
        }
        if(root.right!=null){
            map.get(root.val).add(root.right.val);
            if(!map.containsKey(root.right.val)){
                map.put(root.right.val, new HashSet<>());
                map.get(root.right.val).add(root.val);
            }
        }
        MakeGraph(map, root.left);
        MakeGraph(map, root.right);

    }
}