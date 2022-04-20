package com.learning;

import java.util.Stack;

/**
 * @author 刘乾坤
 * @date 2022/4/20
 */
public class LengthLongestPath {

    public static int lengthLongestPath(String input) {
        int result = 0;
        // 上一层的深度，初始值是0
        int preLevel = 0;
        String[] lines = input.split("\n");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < lines.length; i++) {
            String curLine = lines[i];
            String[] split = curLine.split("\t");
            // 当前层的深度
            String fileName = split[split.length - 1];
            int curLevel = split.length;
            if (curLevel > preLevel) {
                stack.push(fileName);
            }
            else if (curLevel == preLevel) {
                stack.pop();
                stack.push(fileName);
            }
            else if (curLevel < preLevel) {
                int diffLevel = preLevel - curLevel;
                for (int j = 0; j < diffLevel + 1; j++) {
                    stack.pop();
                }
                stack.push(fileName);
            }
            preLevel = curLevel;
            if (fileName.contains(".")) {
                int tempResult = 0;
                for (int j = 0; j < stack.size(); j++) {
                    tempResult += stack.get(j).length() + 1;
                }
                tempResult -= 1;
                result = Math.max(tempResult, result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int i = lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext");
        System.out.println(i);
    }
}
