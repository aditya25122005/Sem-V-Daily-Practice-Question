/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 * https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg$0    TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }https://assets.leetcode.com/uploads/2020/10/13/exx1.jpg$0
 */
class Solution {
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        Solve(root);
        return maxSum;
    }
    public int Solve(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Solve(root.left);
        int right = Solve(root.right);
        int curr = root.val + Math.max(0,left)+ Math.max(0,right);
        maxSum = Math.max(maxSum,curr);

        return Math.max(0,Math.max(left,right))+ root.val;
    }
}