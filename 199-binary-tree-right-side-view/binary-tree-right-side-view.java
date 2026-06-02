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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ll = new ArrayList<>();
        Solve(root,0,ll);
        return ll;
    }
    public static void Solve(TreeNode root, int level, List<Integer> ll){
        if(root == null){
            return;
        }
        if(level == ll.size()){
            ll.add(root.val);
        }
        Solve(root.right,level+1,ll);
        Solve(root.left,level+1,ll);
    }
}