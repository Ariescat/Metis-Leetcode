package com.ariescat.metis.leetcode.todo;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 *
 * @date 2021-10-14, 周四
 */
public class Main_0377_组合总和Ⅳ {

    public static void main(String[] args) {
        System.err.println(Main_0377_组合总和Ⅳ.combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
