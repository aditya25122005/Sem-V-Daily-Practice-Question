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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        return Solve(root,targetSum,0);
    }
    public static boolean Solve(TreeNode root, int target, int curr){
        if(root==null){
            return false;
        }

        curr+= root.val;
        if(root.left==null && root.right==null){
            return curr==target;
        }
        boolean a= Solve(root.left,target,curr);
        boolean b= Solve(root.right,target,curr);

        return a || b;

    }
}