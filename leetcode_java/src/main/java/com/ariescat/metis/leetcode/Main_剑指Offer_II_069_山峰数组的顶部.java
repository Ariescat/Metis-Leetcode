package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/B1IidL/
 *
 * @date 2021-10-14, 周四
 */
public class Main_剑指Offer_II_069_山峰数组的顶部 {

    public static void main(String[] args) {
        System.err.println(Main_剑指Offer_II_069_山峰数组的顶部.peakIndexInMountainArray(new int[]{1, 3, 5, 4, 2}));
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int n = arr.length, left = 0, right = n - 2;
        while (left < right) {
            int mid = left + (right - left >> 1);
            if (arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
