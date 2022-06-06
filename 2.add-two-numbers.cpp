/*
 * @lc app=leetcode id=2 lang=cpp
 *
 * [2] Add Two Numbers
 */

#include <bits/stdc++.h>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        int sum = l1->val + l2->val;
        ListNode *res = new ListNode(sum % 10);
        ListNode *acc = res;
        int r = sum / 10;
        l1 = l1->next; l2 = l2->next;
        while ((l1 != nullptr) && (l2 != nullptr)) {
            sum = r + (l1->val + l2->val);
            ListNode *nNode = new ListNode(sum % 10);
            r = sum / 10;
            acc->next = nNode;
            acc = nNode;
            l1 = l1->next;
            l2 = l2->next;
        }
        while (l1 != nullptr) {
            sum = r + l1->val;
            ListNode *nNode = new ListNode(sum % 10);
            r = sum / 10;
            acc->next = nNode;
            acc = nNode;
            l1 = l1->next;
        }
        while (l2 != nullptr) {
            sum = r + l2->val;
            ListNode *nNode = new ListNode(sum % 10);
            r = sum / 10;
            acc->next = nNode;
            acc = nNode;
            l2 = l2->next;
        }
        if (r != 0) {
            ListNode *nNode = new ListNode(r);
            acc->next = nNode;
        }
        return res;
    }
};
// @lc code=end

