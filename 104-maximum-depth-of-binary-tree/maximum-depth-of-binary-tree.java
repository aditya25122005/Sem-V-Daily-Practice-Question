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
    int maxD;
    public int maxDepth(TreeNode root) {
        maxD = 0;
        Solve(root);
        return maxD;

    }
    public int Solve(TreeNode root){
        if(root ==  null){
            return 0;
        }
        int left = Solve(root.left);
        int right = Solve(root.right);
        maxD = Math.max(maxD, 1+Math.max(left,right));
        return 1+Math.max(left,right);
    }
}