package com.ariescat.metis.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/next-greater-element-i/
 *
 * @date 2021-10-26, 周二
 */
public class Main_0496_下一个更大元素I {

    public static void main(String[] args) {
        System.err.println(Arrays.toString(
                Main_0496_下一个更大元素I.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> num2Index = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            num2Index.put(nums2[i], i);
        }
        int[] ret = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer index = num2Index.get(nums1[i]);
            if (index == null) {
                ret[i] = -1;
            } else {
                boolean find = false;
                for (int j = index + 1; j < nums2.length; j++) {
                    if (nums2[j] > nums1[i]) {
                        ret[i] = nums2[j];
                        find = true;
                        break;
                    }
                }
                if (!find) {
                    ret[i] = -1;
                }
            }
        }
        return ret;
    }
}
