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
    public int maxLevelSum(TreeNode root) {
        int maxSum=Integer.MIN_VALUE;
        int anslevel=0;
        int level=0;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            level++;
            int currlevel=0;
            for(int s=0;s<size;s++){
                TreeNode nn= q.poll();
                currlevel+= nn.val;
                if(nn.left!=null){
                    q.add(nn.left);
                }
                if(nn.right!=null){
                    q.add(nn.right);
                }
            }
            if(currlevel>maxSum){
                maxSum=currlevel;
                anslevel=level;
            }
        }
        return anslevel;
    }
}