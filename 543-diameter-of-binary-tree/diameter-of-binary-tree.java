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
    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        Solve(root);
        return max-1;
    }
    int max;
    public int Solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Solve(root.left);
        int right = Solve(root.right);

        int curr = 1+left+right;
        max = Math.max(max,curr);

        return Math.max(left,right)+1;
    }
}