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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> dp= new HashMap<>();
        return Solver(root,dp);
    }
    public static int Solver(TreeNode root,HashMap<TreeNode,Integer> dp){
        if(root==null ){
            return 0;
        }
        if(dp.containsKey(root)){
            return dp.get(root);
        }
        int one=root.val;
        if(root.left!=null && root.left.left!=null){
        one+=Solver(root.left.left,dp);
        }
        if(root.left!=null && root.left.right!=null){
        one+=Solver(root.left.right,dp);
        }
        if(root.right!=null && root.right.left!=null){
        one+=Solver(root.right.left,dp);
        }
        if(root.right!=null && root.right.right!=null){
        one+=Solver(root.right.right,dp);
        }
        // if(root.left!=null) Solver(root.left.left);
        // if(root.left!=null) Solver(root.left.left);

        int two=Solver(root.left,dp)+Solver(root.right,dp);
        int res=Math.max(one,two);
        dp.put(root,res);
        return res;

    }
}