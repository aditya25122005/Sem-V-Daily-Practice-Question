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
    public int minDiffInBST(TreeNode root) {
        int ans= Integer.MAX_VALUE;
        List<TreeNode> ll= new ArrayList<>();
        Solve(root,ll);
        for(int i=0;i<ll.size()-1;i++){
            ans= Math.min(ans, Math.abs(ll.get(i).val- ll.get(i+1).val));
        }
        return ans;
    }
    
    public void Solve(TreeNode root,List<TreeNode> ll){
        if(root==null){
            return;
        }
        Solve(root.left,ll);
        ll.add(root);
        Solve(root.right,ll);
    }
}