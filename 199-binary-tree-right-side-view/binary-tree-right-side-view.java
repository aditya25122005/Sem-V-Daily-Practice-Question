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
        List<Integer> ll= new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        ll.add(root.val);
        View(root,ll,0);
        return ll;
    }
     int maxD=0;
    public  void View(TreeNode root, List<Integer> ll, int cl){
        if(root==null){
            return;
        }
        if(maxD<cl){
            ll.add(root.val);
            maxD=cl;
        }
        View(root.right,ll,cl+1);
        View(root.left,ll,cl+1);
    }
}