package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/integer-replacement/solution/zheng-shu-ti-huan-by-leetcode-solution-swef/
 *
 * @date 2021-11-19, 周五
 */
public class Main_0397_整数替换 {

    public static void main(String[] args) {
        System.err.println(Main_0397_整数替换.integerReplacement(8));
        System.err.println(Main_0397_整数替换.integerReplacement(7));
        System.err.println(Main_0397_整数替换.integerReplacement(4));
    }

    public static int integerReplacement(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }
}
