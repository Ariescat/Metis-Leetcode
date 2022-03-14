package com.ariescat.metis.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main_0599_两个列表的最小索引总和 {

    public static void main(String[] args) {
        String[] str1 = new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] str2 = new String[]{"KFC", "Shogun", "Burger King"};
        String[] ret = Main_0599_两个列表的最小索引总和.findRestaurant(str1, str2);
        Arrays.stream(ret).forEach(System.out::println);
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> str2Index = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            str2Index.put(list1[i], i);
        }

        int indexSumMin = Integer.MAX_VALUE;
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            String curStr = list2[i];
            Integer index = str2Index.get(curStr);
            if (index != null) {
                int curIndexSum = index + i;
                if (curIndexSum < indexSumMin) {
                    ret.clear();
                    ret.add(curStr);
                    indexSumMin = curIndexSum;
                } else if (curIndexSum == indexSumMin) {
                    ret.add(curStr);
                }
            }
        }
        return ret.toArray(new String[ret.size()]);
    }
}
