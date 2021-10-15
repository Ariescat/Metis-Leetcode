package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * @date 2021-10-15, 周五
 */
public class Main_0038_外观数列 {

    public static void main(String[] args) {
        System.err.println(Main_0038_外观数列.countAndSay(1));
        System.err.println(Main_0038_外观数列.countAndSay(2));
        System.err.println(Main_0038_外观数列.countAndSay(3));
        System.err.println(Main_0038_外观数列.countAndSay(4));
        System.err.println(Main_0038_外观数列.countAndSay(5));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder builder = new StringBuilder();
        String pre = countAndSay(n - 1);
        int ans = 1;
        for (int i = 0; i < pre.length() - 1; i++) {
            if (pre.charAt(i) == pre.charAt(i + 1)) {
                ans++;
            } else {
                builder.append(ans).append(pre.charAt(i));
                ans = 1;
            }
        }
        builder.append(ans).append(pre.charAt(pre.length() - 1));
        return builder.toString();
    }
}
