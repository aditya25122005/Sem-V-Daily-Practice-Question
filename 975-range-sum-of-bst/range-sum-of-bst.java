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
    int sum=0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sum=0;
        Solve(root,low,high);
        return sum;
    }

    public void Solve(TreeNode root, int lo, int hi){
        if(root==null){
            return;
        }
        if(root.val>=lo && root.val<=hi){
            sum+= root.val;
            Solve(root.left,lo,hi);
            Solve(root.right,lo,hi);
        }
        else if(root.val<lo){
            Solve(root.right,lo,hi);
        }
        else if(root.val>hi){
            Solve(root.left,lo,hi);
        }
    }
}