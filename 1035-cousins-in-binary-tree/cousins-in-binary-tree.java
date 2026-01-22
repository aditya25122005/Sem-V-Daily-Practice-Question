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
    int x_level;
    int y_level;
    TreeNode x_father;
    TreeNode y_father;
    public boolean isCousins(TreeNode root, int x, int y) {
        x_level=0;
        y_level=0;
        Solve(root,x,y,1,null);
        return (x_level==y_level) && (x_father!=y_father);


    }
    public  void Solve(TreeNode root, int x, int y,int level,TreeNode parent){

        if(root==null){
            return;
        }
        if(root.val==x){
            x_level=level;
            x_father=parent;
        }
        if(root.val==y){
            y_level=level;
            y_father=parent;
        }
        Solve(root.left,x,y,level+1, root);
        Solve(root.right,x,y,level+1, root);

    }

}