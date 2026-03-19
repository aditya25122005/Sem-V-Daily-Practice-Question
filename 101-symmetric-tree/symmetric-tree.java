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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if(root.left==null && root.right==null){
            return true;
        }
        if(root.left==null){
            return false;
        }
        if(root.right==null){
            return false;
        }
        return Solve(root.left,root.right);
    }
    public static boolean Solve(TreeNode left, TreeNode right){

        if(left==null && right==null){
            return true;
        }
        if(left==null) return false;
        if(right==null) return false;
        
        if(left.val != right.val){
            return false;
        }
     
        
        boolean L= Solve(left.left, right.right);
        boolean R= Solve(left.right,right.left);


        return L&&R;
    }
        
}