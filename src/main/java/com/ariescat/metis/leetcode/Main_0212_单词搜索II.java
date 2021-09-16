package com.ariescat.metis.leetcode;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-search-ii/
 *
 * @date 2021-09-16, 周四
 */
public class Main_0212_单词搜索II {

    public static void main(String[] args) {
        System.err.println(new Main_0212_单词搜索II()
                .findWords(
                        new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
//                        new String[]{ "oath","pea","eat","rain"}
                        new String[]{"eat"}
                ));
    }

    private int row;
    private int column;
    private Map<Character, List<Pair<Integer, Integer>>> char2Position = new HashMap<>();

    public List<String> findWords(char[][] board, String[] words) {
        // TODO
        this.row = board.length;
        this.column = board[0].length;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<Pair<Integer, Integer>> list = char2Position.computeIfAbsent(board[i][j], key -> new ArrayList<>());
                list.add(Pair.of(i, j));
            }
        }

        List<String> ans = new ArrayList<>();
        for (String word : words) {
            List<Pair<Integer, Integer>> pairs = char2Position.get(word.charAt(0));
            if (pairs == null) {
                continue;
            }
            if (find(word, 0)) {
                ans.add(word);
            }
        }
        return ans;
    }

    private boolean find(String word, int index) {
        if (index + 1 >= word.length()) {
            return true;
        }
        List<Pair<Integer, Integer>> pairs = char2Position.get(word.charAt(index));
        if (pairs == null) {
            return false;
        }

        for (Pair<Integer, Integer> position : pairs) {
            List<Pair<Integer, Integer>> nexts = char2Position.get(word.charAt(index + 1));
            if (nexts == null) {
                continue;
            }
            for (Pair<Integer, Integer> next : nexts) {
                if (isNear(position, next) && find(word, index + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private void findFour() {

    }


    private boolean isNear(Pair<Integer, Integer> pos1, Pair<Integer, Integer> pos2) {
        if (pos2.fst < 0 || pos2.fst > row - 1) {
            return false;
        }
        if (pos2.snd < 0 || pos2.snd > column - 1) {
            return false;
        }
        return Math.abs(pos1.fst - pos2.fst) == 1 && Math.abs(pos1.snd - pos2.snd) == 1;
    }

    static class Pair<A, B> {

        public final A fst;
        public final B snd;

        public Pair(A fst, B snd) {
            this.fst = fst;
            this.snd = snd;
        }

        public String toString() {
            return "Pair[" + fst + "," + snd + "]";
        }

        public boolean equals(Object other) {
            return
                    other instanceof Pair<?, ?> &&
                            Objects.equals(fst, ((Pair<?, ?>) other).fst) &&
                            Objects.equals(snd, ((Pair<?, ?>) other).snd);
        }

        public int hashCode() {
            if (fst == null) return (snd == null) ? 0 : snd.hashCode() + 1;
            else if (snd == null) return fst.hashCode() + 2;
            else return fst.hashCode() * 17 + snd.hashCode();
        }

        public static <A, B> Pair<A, B> of(A a, B b) {
            return new Pair<>(a, b);
        }
    }
}
