package com.learning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘乾坤
 * @date 2022/4/18
 */
public class LexicalOrder {

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, result);
        }
        return result;
    }

    public static void dfs(int cur, int n, List<Integer> result) {
        if (cur > n) {
            return;
        }
        result.add(cur);
        for (int i = 0; i < 10; i++) {
            dfs(cur * 10 + i, n, result);
        }
    }

    public static void main(String[] args) {
        List<Integer> integers = lexicalOrder(13);
        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i) + " ");
        }
    }

}
