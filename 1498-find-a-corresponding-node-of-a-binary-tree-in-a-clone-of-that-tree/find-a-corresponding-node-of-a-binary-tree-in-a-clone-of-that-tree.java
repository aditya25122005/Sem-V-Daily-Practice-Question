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
    TreeNode nn = new TreeNode();
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Solve(cloned,target);
        return nn;
    }
    public void Solve( TreeNode root, TreeNode target){
        if(root==null){
            return;
        }
        Solve(root.left,target);
        if(root.val==target.val){
            nn=root;
        }
        Solve(root.right,target);
    }
}