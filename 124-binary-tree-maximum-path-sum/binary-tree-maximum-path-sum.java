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
    public int maxPathSum(TreeNode root) {
        max=Integer.MIN_VALUE;
        Solve(root);

        return max;
    }

    int max=Integer.MIN_VALUE;

    public  int Solve(TreeNode root){
        if(root==null){
            return 0;
        }

        int left= Math.max(Solve(root.left),0);
        int right= Math.max(Solve(root.right),0);

        int curr= root.val+ left+ right;
        max=Math.max(max,curr);

        return Math.max(left,right)+root.val;
    }
}