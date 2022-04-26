package com.learning;

/**
 * @author 刘乾坤
 * @date 2022/4/26
 */
public class ProjectionArea {

    // [1, 2]
    // [3, 4]

    public static int projectionArea(int[][] grid) {
        // 计算XZ面上的投影
        int xz = 0;
        int temp = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                temp = Math.max(temp, grid[j][i]);
            }
            xz += temp;
            temp = 0;
        }
        int xy = 0;
        int yz = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                temp = Math.max(temp, grid[i][j]);
                if (grid[i][j] != 0) {
                    xy++;
                }
            }
            yz += temp;
            temp = 0;
        }
        return xz + xy + yz;
    }

    public static void main(String[] args) {
        System.out.println(projectionArea(new int[][]{new int[]{1,2}, new int[]{3,4}}));
    }
}
