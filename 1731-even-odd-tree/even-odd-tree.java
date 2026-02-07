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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        int level=0;
        while(!q.isEmpty()){
            int size= q.size();
            int prev=0;
            if(level%2==1){
                prev=Integer.MAX_VALUE;
            }
            for(int i=0;i<size;i++){
                TreeNode nn = q.poll();
                int val= nn.val;
                if(level%2==0){
                    if(val%2==0 ||val<= prev){
                        return false;
                    }
                    else{
                        prev=val;
                    }
                }
                else{
                    if(val%2==1 || val>=prev){
                        return false;
                    }
                    else{
                        prev=val;
                    }
                }

                if(nn.left!=null){
                    q.add(nn.left);
                }
                if(nn.right!=null){
                    q.add(nn.right);
                }

            }
            level++;
        }
        return true;
    }
}