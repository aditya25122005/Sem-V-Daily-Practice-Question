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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ll= new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        Solve(root,ll,inner,0,targetSum);
        return ll;

    }
    public static void Solve(TreeNode root,List<List<Integer>> ll, List<Integer> inner, int curr, int target){
        if(root==null){
            return;
        }
        curr+= root.val;
        if(root.left==null && root.right==null){
            if(curr==target){
                inner.add(root.val);
                ll.add(new ArrayList<>(inner));
                inner.remove(inner.size()-1);
                return;
            }
            else{
                return;
            }
        }
        inner.add(root.val);
        Solve(root.left,ll,inner,curr,target);
        Solve(root.right,ll,inner,curr,target);

        inner.remove(inner.size()-1);

    }
}