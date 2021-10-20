package com.ariescat.metis.leetcode.todo;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/
 *
 * @date 2021-10-20, 周三
 */
public class Main_0453_最小操作次数使数组元素相等 {

    public static void main(String[] args) {

    }

    public static int minMoves(int[] nums) {
        int minNum = Arrays.stream(nums).min().getAsInt();
        int res = 0;
        for (int num : nums) {
            res += num - minNum;
        }
        return res;
    }
}
