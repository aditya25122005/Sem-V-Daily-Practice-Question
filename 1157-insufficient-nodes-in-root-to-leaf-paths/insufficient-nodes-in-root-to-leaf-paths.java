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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root==null){
            return null;
        }

        return solve(root,limit,0);
    }
    public TreeNode solve(TreeNode root, int limit, int curr){
        if(root==null){
            return null;
        }
        curr+=root.val;
        if(root.left==null && root.right==null){
            if(curr<limit){
                return null;
            }
            else{
                return root;
            }
        }
       root.left= solve(root.left,limit,curr);
       root.right= solve(root.right,limit,curr);

       if(root.left==null && root.right==null){
        return null;
       }
       return root;
    }
}