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
    public int minDepth(TreeNode root) {
        
        return Solve(root);
        
    }
    public static int Solve(TreeNode root){
        if(root==null){
            return 0;
        }
        

        if(root.left==null && root.right==null){
            return 1;
        }
        int lh=Solve(root.left);
        int rh=Solve(root.right);
        if(lh==0 || rh==0){
            return lh+rh+1;
        }
        return Math.min(lh,rh)+1;
    }
}