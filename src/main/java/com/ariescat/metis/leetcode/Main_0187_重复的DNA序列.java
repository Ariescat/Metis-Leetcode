package com.ariescat.metis.leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/repeated-dna-sequences/
 *
 * @date 2021-10-08, 周五
 */
public class Main_0187_重复的DNA序列 {

    public static void main(String[] args) {
        System.err.println(Main_0187_重复的DNA序列.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }

    static final int L = 10;

    public static List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < L) {
            return Collections.emptyList();
        }
        List<String> ans = new ArrayList<>();
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i <= s.length() - L; i++) {
            String sub = s.substring(i, i + L);
            cnt.put(sub, cnt.getOrDefault(sub, 0) + 1);
            if (cnt.get(sub) == 2){
                ans.add(sub);
            }
        }
        return ans;
    }
}
