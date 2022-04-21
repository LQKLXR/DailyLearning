package com.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 刘乾坤
 * @date 2022/4/21
 */
public class ToGoatLatin {


    public static String toGoatLatin(String sentence) {
        // 直接穷举大小写，比运行时转大小写速度快
        List<Character> maList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        String[] split = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            stringBuilder.append("a");
            // 有元音字母 拼接 ma和 索引个a
            // 没有元音字母，但是长度为1，把第一个字母放到最后，相当于不变，还可以用这一步
            if (maList.contains(split[i].charAt(0)) || split[i].length() <= 1) {
                split[i] = split[i] + "ma" + stringBuilder.toString();
            }
            // 没有元音字母，且长度大于1，需要手动吧第一个字母放到最后，然后再拼接 ma 和 索引个a
            else {
                split[i] = split[i].substring(1) + split[i].substring(0, 1) + "ma" + stringBuilder.toString();
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            result.append(split[i]);
            if (i != split.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(toGoatLatin("yDumm"));
    }
}
