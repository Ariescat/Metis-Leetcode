package com.ariescat.metis.leetcode.todo;

/**
 * https://leetcode-cn.com/problems/decode-ways-ii/
 *
 * @date 2021-09-27, 周一
 */
public class Main_0639_解码方法II {

    public static void main(String[] args) {
//        System.err.println(Main_0639_解码方法II.numDecodings("*"));
//        System.err.println(Main_0639_解码方法II.numDecodings("**"));
        System.err.println(Main_0639_解码方法II.numDecodings2("7*9*3*6*3*0*5*4*9*7*3*7*1*8*3*2*0*0*6*"));
    }

    static final int MOD = 1000000007;

    public static int numDecodings(String s) {
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                dp[i] = (dp[i] + dp[i - 2] * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
        }
        return (int) dp[n];
    }

    public static int numDecodings2(String s) {
        int n = s.length();
        // a = f[i-2], b = f[i-1], c = f[i]
        long a = 0, b = 1, c = 0;
        for (int i = 1; i <= n; ++i) {
            c = b * check1digit(s.charAt(i - 1)) % MOD;
            if (i > 1) {
                c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % MOD;
            }
            a = b;
            b = c;
        }
        return (int) c;
    }

    public static int check1digit(char ch) {
        if (ch == '0') {
            return 0;
        }
        return ch == '*' ? 9 : 1;
    }

    public static int check2digits(char c0, char c1) {
        if (c0 == '*' && c1 == '*') {
            return 15;
        }
        if (c0 == '*') {
            return c1 <= '6' ? 2 : 1;
        }
        if (c1 == '*') {
            if (c0 == '1') {
                return 9;
            }
            if (c0 == '2') {
                return 6;
            }
            return 0;
        }
        return (c0 != '0' && (c0 - '0') * 10 + (c1 - '0') <= 26) ? 1 : 0;
    }

}
