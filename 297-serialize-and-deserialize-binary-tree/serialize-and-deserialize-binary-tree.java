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
    String res;
    public String serialize(TreeNode root) {
        res = "";
        op1(root);
        System.out.println(res);
        deserialize(res);
        return res;
    }
    public void op1(TreeNode root){
        if(root==null){
            res+= "null,";
            return;
        }
        res+= root.val+",";
        
        op1(root.left);
        op1(root.right);
    }

    // Decodes your encoded data to tree.
    int idx;
    public TreeNode deserialize(String data) {
        idx = 0;
        String [] arr = data.split(","); 
        return encode(arr); 
        // TreeNode nn = new TreeNode(arr[idx++]);
    }
    public TreeNode encode(String[] arr){
        if(idx>=arr.length){
            return null;
        }
        String s = arr[idx++];
        if(s.equals("null")){
            return null;
        }
        TreeNode nn = new TreeNode(Integer.parseInt(s));
        nn.left = encode(arr);
        nn.right = encode(arr);


        return nn;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));