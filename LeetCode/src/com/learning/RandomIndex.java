package com.learning;

import java.util.Random;

/**
 * 随机数索引
 *
 * @author 刘乾坤
 * @date 2022/4/25
 */
public class RandomIndex {

    private int[] nums;

    public RandomIndex(int[] nums) {
        this.nums = nums;
    }

    public int pick(int target) {
        // 最终的结果
        int result = 0;
        // 到目前为止，遇到第几次target.
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if ((new Random().nextInt(++count) == 0)) {
                    result = i;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        RandomIndex randomIndex = new RandomIndex(new int[]{1, 2, 3, 3, 3});
        System.out.println(randomIndex.pick(3));
    }


}
