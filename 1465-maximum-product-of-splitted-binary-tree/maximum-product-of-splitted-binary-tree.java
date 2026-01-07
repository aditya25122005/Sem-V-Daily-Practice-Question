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

        long total= totalSum(root);
        maxProduct=0;
        Solve(root,total);
        return (int)(maxProduct%1000000007);

    }
    static long maxProduct;
    public static long Solve(TreeNode root, long total){
        if(root==null){
            return 0;
        }
       
        long left=Solve(root.left,total);
        long right=Solve(root.right,total);

        long subtreeSum = root.val + left + right;
        maxProduct=Math.max(maxProduct, (long)(subtreeSum*(total-subtreeSum)));
        return subtreeSum;
    }
    public static long totalSum(TreeNode root){
        if(root==null){
            return 0;
        }
        return root.val+(totalSum(root.left))+ totalSum(root.right);
    }
}