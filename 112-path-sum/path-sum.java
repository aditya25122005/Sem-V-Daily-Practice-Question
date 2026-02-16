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
        
        return Solve(root,0,targetSum);
    }
    public static boolean Solve(TreeNode root, int curr , int target){
        if(root==null){
            return false;
        }
        curr+= root.val;
        if(root.left==null && root.right==null){
           return  curr==target;
        }

        boolean A= Solve(root.left, curr, target);
        boolean B= Solve(root.right, curr,target);
        return A || B;

    }
}