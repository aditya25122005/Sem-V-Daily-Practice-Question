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
    public int sumNumbers(TreeNode root) {
        sum=0;
        help(root,"");
        return sum;
    }
    static int sum=0;
    public void help(TreeNode root,String s){
        if(root==null){
            return;
        }
        s+=root.val;
        if(root.left==null && root.right==null){
            sum+=Integer.parseInt(s);
            return;
        }
       help(root.left,s);
       help(root.right,s);

    }
}