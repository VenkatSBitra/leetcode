import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=638 lang=java
 *
 * [638] Shopping Offers
 */

// @lc code=start
class Solution {
    int[] specials;
    int[] needsArray;
    HashMap<String, Integer> hMap;

    public int helper(List<Integer> price, List<List<Integer>> special) {
        boolean check = Arrays.stream(needsArray).allMatch(n -> n == 0);
        if (check) return 0;
        for (List<Integer> s: special) {

        }
        return 0;
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        specials = new int[special.size()];
        needsArray = needs.stream().mapToInt(i->i).toArray();
        hMap = new HashMap<>();
        return 0;
    }
}
// @lc code=end

