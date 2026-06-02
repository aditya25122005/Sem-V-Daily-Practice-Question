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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ll = new ArrayList<>();
        Solve(root,"",ll);
        return ll;
    }
    public static void Solve(TreeNode root, String ans,List<String> ll){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ans = ans+root.val;
            ll.add(ans);
            return;
        }
        Solve(root.left,ans+root.val+"->",ll);
        Solve(root.right,ans+root.val+"->",ll);
    }
}