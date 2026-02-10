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

 // perfect binary tree-> Every Internal node has 2 child and all  leaf nodes are at same level
class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Solve(root.left, root.right, 1);
        return root;
    }
    public static void Solve(TreeNode left, TreeNode right,int level){
        if(left==null && right==null){
            return;
        }
        if(level%2==1){
            int temp= left.val;
            left.val= right.val;
            right.val= temp;
        }
        Solve(left.left,right.right, level+1);
        Solve(left.right,right.left, level+1);
    }
}