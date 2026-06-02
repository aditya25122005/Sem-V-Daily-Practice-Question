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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode rm = q.poll();
                if(i==size-1){
                    ans.add(rm.val);
                }
                if(rm.left!=null){
                    q.add(rm.left);
                }
                if(rm.right!=null){
                    q.add(rm.right);
                }
            }
        }
        return ans;
    }
}