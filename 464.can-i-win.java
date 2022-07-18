import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode id=464 lang=java
 *
 * [464] Can I Win
 */

// @lc code=start
class Solution {
    HashMap<String, Boolean> resMap = new HashMap<>();
    boolean[] moves;

    public boolean canWin(int rem) {
        if (rem <= 0) return false;
        String moveStr = Arrays.toString(moves);
        if (!resMap.containsKey(moveStr)) {
            for (int i = 1; i < moves.length; i++) {
                if (!moves[i]) {
                    moves[i] = true;
                    if (!canWin(rem - i)) {
                        moves[i] = false;
                        resMap.put(moveStr, true);
                        return true;
                    }
                    moves[i] = false;
                }
            }
            resMap.put(moveStr, false);
        }
        return resMap.get(moveStr);
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= maxChoosableInteger) return true;
        if (desiredTotal > maxChoosableInteger * (maxChoosableInteger + 1) / 2) return false;
        moves = new boolean[maxChoosableInteger + 1];
        return canWin(desiredTotal);
    }
}
// @lc code=end

