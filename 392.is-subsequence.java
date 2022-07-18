import java.util.HashMap;
import java.util.Stack;

/*
 * @lc app=leetcode id=392 lang=java
 *
 * [392] Is Subsequence
 */

// @lc code=start
class Solution {
    // Complexity: O(s * t)
    private HashMap<String, Boolean> map = new HashMap<>();

    public boolean helper(String s, String t, int si, int ti) {
        if (si == s.length()) return true;
        if (ti == t.length()) return false;
        if (map.containsKey(si+"_"+ti)) return map.get(si+"_"+ti);
        boolean res = false;
        if (s.charAt(si) == t.charAt(ti)) 
            res = res || helper(s, t, si + 1, ti + 1);
        else
            res = res || helper(s, t, si, ti + 1);
        map.put(si+"_"+ti, res);
        return res;
    }

    public boolean isSubsequence(String s, String t) {
        // return helper(s, t, 0, 0);
        Stack<Character> ss = new Stack<>(), st = new Stack<>();
        for (int i = 0; i < s.length(); i++) ss.push(s.charAt(i));
        for (int i = 0; i < t.length(); i++) st.push(t.charAt(i));
        while (!ss.empty() && !st.empty()) {
            if (ss.peek() == st.peek()) {
                ss.pop(); st.pop();
            } else {
                st.pop();
            }
        }
        return ss.empty();
    }
}
// @lc code=end

