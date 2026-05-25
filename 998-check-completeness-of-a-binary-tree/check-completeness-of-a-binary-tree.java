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
    public boolean isCompleteTree(TreeNode root) {
        if(root==null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean seenNull = false;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode rm = q.poll();
                if(rm.left!=null){
                    if(seenNull){
                        return false;
                    }
                    q.add(rm.left);
                }
                if(rm.left==null){
                    seenNull= true;
                }
                if(rm.right!=null ){
                    if(seenNull){
                        return false;
                    }
                    q.add(rm.right);
                }
                if(rm.right==null){
                    seenNull = true;
                }
                
            }
        }
        return true;
    }
}