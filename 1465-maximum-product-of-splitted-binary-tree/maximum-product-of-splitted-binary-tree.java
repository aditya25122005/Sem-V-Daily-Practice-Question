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
    public int maxProduct(TreeNode root) {
        ans=1;
        total= Sum(root);
        Solve(root);
        return (int)(ans%1000000007);

    }
    static long ans;

    static int total;

    public static long Solve(TreeNode root){
        if(root==null){
            return 0;
        }
        long left = Solve(root.left); // left subtree 
        long right= Solve(root.right); // right Subtree
        long subtree = left+right+root.val;
        ans=Math.max(ans, (long)(total-subtree)*(subtree));
        return subtree;
    }

    public static int Sum(TreeNode root){
        if(root==null){
            return 0;
        }
        int left= Sum(root.left);
        int right=Sum(root.right);
        return left+right+root.val;
    }
}