// main.cpp
#include <iostream>
#include <string>
#include <vector>
#include <stack>
#include <unordered_set>

using namespace std;

// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {
public:
    vector<int> postorder(Node* root) {
    
        vector<int> res;
        if (root == nullptr) {
            return res;
        }

        stack<Node *> st;
        unordered_set<Node *> visited;
        st.emplace(root);
        while (!st.empty()) {
            Node * node = st.top();
            /* 如果当前节点为叶子节点或者当前节点的子节点已经遍历过 */
            if (node->children.size() == 0 || visited.count(node)) {
                res.emplace_back(node->val);
                st.pop();
                continue;
            }
            for (auto it = node->children.rbegin(); it != node->children.rend(); it++) {
                st.emplace(*it);
            }
            visited.emplace(node);
        }       
        return res;
    }
};

int main()
{

    printf("Hello Main_0590_N叉树的后序遍历");

    return 0;
}