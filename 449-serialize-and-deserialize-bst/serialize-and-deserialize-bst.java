/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    StringBuilder sb;
    public String serialize(TreeNode root) {
        sb= new StringBuilder();
        Solve(root);
        return sb.toString();
    }
    public void Solve(TreeNode root){
        if(root==null){
            sb.append("null,");
            return;
        }
        sb.append(root.val).append(",");
        Solve(root.left);
        Solve(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String [] pre= data.split(",");
        return Solve2(pre);

    }
    int idx=0;
    public TreeNode Solve2(String[] pre){
        if(idx==pre.length){
            return null;
        }
        String s= pre[idx++];
        if(s.equals("null")){
            return null;
        }
        TreeNode nn= new TreeNode(Integer.parseInt(s));
        nn.left= Solve2(pre);
        nn.right= Solve2(pre);

        return nn;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;