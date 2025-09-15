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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int count=1;
 
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                TreeNode nn= q.poll();
                

                if(nn.left==null && nn.right==null){
                    return count;
                }
                if(nn.left!=null){
                    q.add(nn.left);
                }
                if(nn.right!=null){
                    q.add(nn.right);
                }
            }
            count++;
        }
        return count;
        
    }
   
}