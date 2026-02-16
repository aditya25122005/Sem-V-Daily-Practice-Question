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
        max=0;
        Solve(root);
        return max;

    }
    static int max;

    public static int Solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int left= 1+ Solve(root.left);
        int right = 1+ Solve(root.right);

        max=Math.max(max, left+right-2);

        return Math.max(left,right);
    }
}