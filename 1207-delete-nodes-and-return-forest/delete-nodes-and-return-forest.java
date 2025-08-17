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
    List<TreeNode> ll= new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        if(root==null) return new ArrayList<>();
        HashSet<Integer> h= new HashSet<>();
        for(int val: to_delete){
            h.add(val); 
        }
        if(!h.contains(root.val)){
            ll.add(root);  // this root will keep on modifying when recursive call occurs
        }
        solve(root,h);
        return ll;


    }
    public TreeNode solve(TreeNode root,HashSet<Integer> h){
        if(root==null){
            return null;
        }
        root.left=solve(root.left,h);
        root.right=solve(root.right,h);

        if(h.contains(root.val)){
            if(root.left!=null) ll.add(root.left);
            if(root.right!=null) ll.add(root.right);
            return null;
        }
        return root;


    }
}