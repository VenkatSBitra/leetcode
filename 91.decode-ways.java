import java.util.HashMap;

/*
 * @lc app=leetcode id=91 lang=java
 *
 * [91] Decode Ways
 */

// @lc code=start
class Solution {
    public HashMap<String, Integer> hashMap = new HashMap<>();

    public int getNumDecodings(String s) {
        if (hashMap.containsKey(s)) return hashMap.get(s);
        if (s.charAt(0) == '0') {
            hashMap.put(s, 0);
            return 0;
        }
        int res = 0;
        if (s.charAt(0) == '1') {
            if (s.length() > 2) res += getNumDecodings(s.substring(2));
            else if (s.length() == 2) res += 1;
        } else if (s.charAt(0) == '2') {
            if (s.length() > 1) {
                if (s.charAt(1) >= '0' && s.charAt(1) <= '6') {
                    if (s.length() > 2) res += getNumDecodings(s.substring(2));
                    else if (s.length() == 2) res += 1;
                }
            }
        }
        res += getNumDecodings(s.substring(1));
        hashMap.put(s, res);
        return res;
    }

    public int numDecodings(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '0') return 0;
            else return 1;
        }
        hashMap.put("", 1);
        return getNumDecodings(s);
    }
}
// @lc code=end

