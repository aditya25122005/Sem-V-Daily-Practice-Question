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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> ll;
        Solve(root,ll);
        return ll;
    }
    void Solve(TreeNode* root, vector<int>& ll){
        if(root==nullptr){
            return;
        }
        ll.push_back(root->val);
        Solve(root->left,ll);
        Solve(root->right,ll);

    }
};