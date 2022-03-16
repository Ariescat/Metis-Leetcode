package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/find-peak-element/
 *
 * @date 2021-09-15, 周三
 */
public class Main_0162_寻找峰值 {

    public static void main(String[] args) {
        Main_0162_寻找峰值.findPeakElement(new int[]{1, 2, 3, 1});
        Main_0162_寻找峰值.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 7});
    }

    public static int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

}
