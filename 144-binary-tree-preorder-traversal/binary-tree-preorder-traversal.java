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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ll= new ArrayList<>();
        Solve(root,ll);
        return ll;
    }
    public static void Solve(TreeNode root, List<Integer> ll){
        if(root==null){
            return;
        }
        ll.add(root.val);
        Solve(root.left,ll);
        Solve(root.right,ll);
       
    }
}