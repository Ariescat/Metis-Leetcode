package com.ariescat.metis.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 *
 * @date 2021-10-13, 周三
 */
public class Main_0412_Fizz_Buzz {

    public static void main(String[] args) {
        System.err.println(Main_0412_Fizz_Buzz.fizzBuzz(15));
    }

    public static List<String> fizzBuzz(int n) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean div3 = i % 3 == 0;
            boolean div5 = i % 5 == 0;
            if (div3 && div5) {
                list.add("FizzBuzz");
            } else if (div3) {
                list.add("Fizz");
            } else if (div5) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }

}
