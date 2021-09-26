package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/power-of-three/
 *
 * @date 2021-09-23, 周四
 */
public class Main_0326_3的幂 {

    public static void main(String[] args) {
        System.err.println(Main_0326_3的幂.isPowerOfThree(27));
        System.err.println(Main_0326_3的幂.isPowerOfThree(0));
        System.err.println(Main_0326_3的幂.isPowerOfThree(9));
        System.err.println(Main_0326_3的幂.isPowerOfThree(45));
    }

    public static boolean isPowerOfThree(int n) {
        if (n == 0 || n == 2) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        while (n > 0) {
            int left = n / 3;
            if (n % 3 != 0) {
                return false;
            }
            if (left == 1) {
                return true;
            }

            n = left;
        }
        return false;
    }

    public boolean isPowerOfThree2(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public boolean isPowerOfThree3(int n) {
        // 最大的 33 的幂为 3^{19} = 11622614673
        return n > 0 && 1162261467 % n == 0;
    }

}
