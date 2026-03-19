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
    static int max;
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        if(root==null){
            return 0;
        }
        Solve(root);
        return max;
    }
    public static int Solve(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = Math.max(0,Solve(root.left));
        int right = Math.max(0, Solve(root.right));
        // int curr= Math.max(Math.max(root.val+left+right,left),right);
        int curr = root.val+left+right;
        max=Math.max(max,curr);

        return root.val+Math.max(left,right);

    }
}