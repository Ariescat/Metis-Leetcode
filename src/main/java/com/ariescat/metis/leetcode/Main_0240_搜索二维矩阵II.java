package com.ariescat.metis.leetcode;

/**
 * https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 * @date 2021-10-25, 周一
 */
public class Main_0240_搜索二维矩阵II {

    public static void main(String[] args) {
//        System.err.println(Main_0240_搜索二维矩阵II.searchMatrix(
//                new int[][]{
//                        {1, 4, 7, 11, 15},
//                        {2, 5, 8, 12, 19},
//                        {3, 6, 9, 16, 22},
//                        {10, 13, 14, 17, 24},
//                        {18, 21, 23, 26, 30}},
//                5));
        System.err.println(Main_0240_搜索二维矩阵II.searchMatrix2(new int[][]{{-5}}, -5));
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length, column = matrix[0].length;
        int x = 0, y = column - 1;
        while (x < row && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            } else {
                if (matrix[x][y] > target) {
                    y--;
                } else {
                    x++;
                }
            }
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (binarySearch(row, target) >= 0) {
                return true;
            }
        }
        return false;
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
