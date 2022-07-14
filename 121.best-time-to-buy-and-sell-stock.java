import java.util.Stack;

/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        int min = prices[0], max = prices[0];
        int ans = 0;
        stack.push(prices[0]);
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= stack.peek()) {
                stack.push(prices[i]);
                max = Math.max(prices[i], max);
            } else {
                while (!stack.isEmpty() && (stack.peek() > prices[i])) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    ans = Math.max(ans, max - min);
                    min = prices[i];
                    max = prices[i];
                    stack.push(prices[i]);
                }
            }
        }
        return Math.max(ans, max - min);
    }
}
// @lc code=end

