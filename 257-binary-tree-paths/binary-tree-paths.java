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
        Solve(root,ll,"");
        return ll;

    }
    public static void Solve(TreeNode root, List<String> ll,String ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            ans+= root.val;
            ll.add(ans);
            return;
        }
        ans+= root.val + "->";
        Solve(root.left,ll,ans);
        Solve(root.right,ll,ans);
    }
}