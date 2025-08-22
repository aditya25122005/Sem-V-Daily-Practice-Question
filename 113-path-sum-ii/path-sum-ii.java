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
    List<List<Integer>> ll;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ll= new ArrayList<>();
        helper(root,targetSum,new ArrayList<>());
        return ll;
    }
    public void helper(TreeNode root, int target,List<Integer>inner){
        if(root==null){
            return;
        }
        inner.add(root.val);

        if(root.left==null && root.right==null && root.val==target){
            ll.add(new ArrayList<>(inner));
        }
        else{
        helper(root.left,target-root.val,inner);
        helper(root.right,target-root.val,inner);
        }
        inner.remove(inner.size()-1);
    }
}