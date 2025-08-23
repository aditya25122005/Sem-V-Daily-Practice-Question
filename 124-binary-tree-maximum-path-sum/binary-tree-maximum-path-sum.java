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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        max=Integer.MIN_VALUE;
        solve(root);
        return max;
    }
    public int solve(TreeNode root){
        if(root==null){
            return 0;
        }

        int left=Math.max(solve(root.left),0);
        int right=Math.max(solve(root.right),0);
        int curr= left+right+root.val;
        max=Math.max(max,curr);

        return root.val+Math.max(left,right);
    }
}