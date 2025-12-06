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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll= new ArrayList<>();
        if(root==null) return ll;

        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> inner= new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode rn= q.poll();
                inner.add(rn.val);
                if(rn.left!=null){
                    q.add(rn.left);

                }
                if(rn.right!=null){
                    q.add(rn.right);
                }
            }
            ll.add(new ArrayList<>(inner));
            


        }
        return ll;
    }
}