package com.learning;

import java.util.Stack;

/**
 * @author 刘乾坤
 * @date 2022/4/20
 */
public class LengthLongestPath {

    public static int lengthLongestPath(String input) {

        String[] lines = input.split("\n");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < lines.length; i++) {
            String curLine = lines[i];
            String[] split = curLine.split("\t");
            if (split.length - 1 > stack.size()) {
                stack.push(split[split.length - 1]);
            }
            else if (split.length - 1 == stack.size()) {

            }
            else if (split.length - 1 < stack.size()) {
                stack.pop();
            }
        }

    }

}
