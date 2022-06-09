/*
 * @lc app=leetcode id=133 lang=cpp
 *
 * [133] Clone Graph
 */

#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> neighbors;
    Node() {
        val = 0;
        neighbors = vector<Node*>();
    }
    Node(int _val) {
        val = _val;
        neighbors = vector<Node*>();
    }
    Node(int _val, vector<Node*> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

class Solution {
public:
    Node* cloneGraph(Node* node) {
        if (node == nullptr) {
            return nullptr;
        } else {
            unordered_map<Node *, Node *> m;
            queue<Node *> q; q.push(node);
            while (!q.empty()) {
                Node *t = q.front(); q.pop();
                m.insert({t, new Node(t->val)});
                for (auto v: t->neighbors) {
                    if (m.find(v) != m.end()) continue;
                    q.push(v);
                }
            }
            for (auto v: m) {
                vector<Node *> n;
                for (auto i: v.first->neighbors) {
                    n.push_back(m[i]);
                }
                v.second->neighbors = n;
            }
            return m[node];
        }
    }
};
// @lc code=end

