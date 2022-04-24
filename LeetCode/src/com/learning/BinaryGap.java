package com.learning;

/**
 * @author 刘乾坤
 * @date 2022/4/24
 */
public class BinaryGap {

    public static int binaryGap(int n) {
        int temp = n;
        int last = 0;
        int cur = 1;

        int result = 0;

        while (temp > 0) {
            if ((temp & 1) > 0 && last != 0) {
                result = Math.max(result, cur - last);
                last = cur;
            }
            else if ((temp & 1) > 0 && last == 0) {
                last = cur;
            }
            ++cur;
            temp = temp >>> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(22));
    }

}
