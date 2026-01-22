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
    int sum;
    public int sumEvenGrandparent(TreeNode root) {
        sum=0;
        Solve(root,null,null);
        return sum;

    }
    public void Solve(TreeNode root, TreeNode parent, TreeNode gp){
        if(root==null){
            return;
        }

        if(parent!=null && gp!=null && gp.val%2==0){
            sum+= root.val;
        }
        Solve(root.left,root,parent);
        Solve(root.right,root,parent);
    }
}