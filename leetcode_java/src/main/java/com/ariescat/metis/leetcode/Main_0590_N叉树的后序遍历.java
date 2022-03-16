package com.ariescat.metis.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main_0590_N叉树的后序遍历 {

    public static void main(String[] args) {
        Node root = new Node(1, new ArrayList<Node>() {
            {
                add(new Node(3, new ArrayList<Node>() {{
                    add(new Node(5));
                    add(new Node(6));
                }}));
                add(new Node(2));
                add(new Node(4));
            }
        });
        List<Integer> postorder = postorder(root);
        System.err.println(postorder);
    }

    public static List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        postorder0(root, res);
        return res;
    }

    public static void postorder0(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }
        for (Node ch : root.children) {
            postorder0(ch, res);
        }
        res.add(root.val);
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
