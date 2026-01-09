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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        List<List<TreeNode>> ll= new ArrayList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            List<TreeNode> inner= new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode nn=q.poll();
                inner.add(nn);

                if(nn.left!=null){
                    q.add(nn.left);
                }
                if(nn.right!=null){
                    q.add(nn.right);
                }
            }
            ll.add(inner);
        }
        List<TreeNode> deepest= ll.get(ll.size()-1);
        int maxHt= ll.size()-1;

        return Solve(0,maxHt,root);
        
    }
    public static TreeNode Solve(int curr, int maxHt, TreeNode root){
        if(root==null){
            return null;
        }
        if(curr==maxHt){
            return root;
        }
        TreeNode left=Solve(curr+1,maxHt,root.left);
        TreeNode right=Solve(curr+1,maxHt,root.right);

        if(left!=null && right!=null){
            return root;
        }
        else if(left==null){
            return right;
        }
        else{
            return left;
        }
    }
}