package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/path-sum-iii/
 *
 * @date 2021-09-28, 周二
 */
public class Main_0437_路径总和III {

    public static void main(String[] args) {
        System.err.println(new Main_0437_路径总和III().pathSum(TreeNode.build2(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8));
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    public int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = 0;
        curr += root.val;

        ret = prefix.getOrDefault(curr - targetSum, 0);
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);

        return ret;
    }

}
