package com.ariescat.metis.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 *
 * @date 2021-11-17, 周三
 */
public class Main_0318_最大单词长度乘积 {

    public static void main(String[] args) {
        System.err.println(Main_0318_最大单词长度乘积.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    }

    public static int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                masks[i] |= 1 << (c - 'a');
            }
        }
        int maxValue = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    maxValue = Math.max(maxValue, words[i].length() * words[j].length());
                }
            }
        }
        return maxValue;
    }

    public static int maxProduct2(String[] words) {
        Map<Integer, Integer> mask2MaxLength = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            if (word.length() > mask2MaxLength.getOrDefault(mask, 0)) {
                mask2MaxLength.put(mask, word.length());
            }
        }
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry : mask2MaxLength.entrySet()) {
            for (Map.Entry<Integer, Integer> innerEntry : mask2MaxLength.entrySet()) {
                if ((entry.getKey() & innerEntry.getKey()) == 0) {
                    maxValue = Math.max(maxValue, entry.getValue() * innerEntry.getValue());
                }
            }
        }
        return maxValue;
    }
}
