package com.ariescat.metis.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/majority-element-ii/
 *
 * @date 2021-10-22, 周五
 */
public class Main_0229_求众数II {

    public static void main(String[] args) {
        System.err.println(Main_0229_求众数II.majorityElement(new int[]{3, 2, 3}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int n_3 = nums.length / 3;
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> num2Counts = new HashMap<>();
        for (int num : nums) {
            num2Counts.put(num, num2Counts.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : num2Counts.entrySet()) {
            if (entry.getValue() > n_3) {
                ret.add(entry.getKey());
            }
        }
        return ret;
    }
}
