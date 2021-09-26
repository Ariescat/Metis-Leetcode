package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/sum-of-two-integers/
 *
 * @date 2021-09-26, 周日
 */
public class Main_0371_两整数之和 {

    public static void main(String[] args) {
        System.err.println(Main_0371_两整数之和.getSum(1, 2));
        System.err.println(Main_0371_两整数之和.getSum(2, 3));
    }

    public static int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getSum(a ^ b, (a & b) << 1);
    }

    public static int getSum2(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
}
