package com.ariescat.metis.leetcode;

import com.ariescat.metis.leetcode.utils.ListNode;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/split-linked-list-in-parts/
 *
 * @date 2021-09-22, 周三
 */
public class Main_0725_分隔链表 {

    public static void main(String[] args) {
        ListNode[] listNodes = Main_0725_分隔链表.splitListToParts(ListNode.build2(1, 2, 3), 5);
//        ListNode[] listNodes = Main_0725_分隔链表.splitListToParts(ListNode.build2(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3);
        Arrays.stream(listNodes).forEach(System.err::println);
    }

    public static ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int seg = size / k;
        int left = size % k;

        ListNode[] parts = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            parts[i] = curr;
            int partSize = seg + (i < left ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }
        return parts;
    }
}
