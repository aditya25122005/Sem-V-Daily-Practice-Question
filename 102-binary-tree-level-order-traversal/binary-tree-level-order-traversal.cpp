/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        std:: queue<TreeNode*> q;
        vector<vector<int>> ll;
        if(root==nullptr){
            return ll;
        }
        q.push(root);
        while(!q.empty()){
            int size = q.size();
            vector<int> inner;
            for(int i=0;i<size;i++){
                TreeNode* rm = q.front();
                q.pop();
                inner.push_back(rm->val);
                if(rm->left!=nullptr){
                    q.push(rm->left);
                }
                if(rm->right!=nullptr){
                    q.push(rm->right);
                }

            }
            ll.push_back(inner);
        }
        return ll;
    }
};