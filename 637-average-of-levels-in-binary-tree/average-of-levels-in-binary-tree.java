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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ll= new ArrayList<>();
        if(root==null){
            return ll;
        }
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            double sum=0;
            for(int i=0;i<size;i++){
                TreeNode rm= q.poll();
                sum+= rm.val;
                if(rm.left!=null){
                    q.add(rm.left);
                }
                if(rm.right!=null){
                    q.add(rm.right);
                }

            }
            ll.add( (double)sum/size);
           
        }
        return ll;

    }
}