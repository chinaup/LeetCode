package Math.Easy;
/*
在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
每个值 v = grid[i][j] 表示 v 个正方体叠放在单元格 (i, j) 上。
返回结果形体的总表面积。

示例 1：
输入：[[2]]
输出：10

示例 2：
输入：[[1,2],[3,4]]
输出：34

示例 3：
输入：[[1,0],[0,2]]
输出：16

示例 4：
输入：[[1,1,1],[1,0,1],[1,1,1]]
输出：32

示例 5：
输入：[[2,2,2],[2,1,2],[2,2,2]]
输出：46

提示：
1 <= N <= 50
0 <= grid[i][j] <= 50
 */
public class SurfaceAreaOf3DShapes_892 {
    public static void main(String[] args){

        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(surfaceArea(grid));
    }
    //每一个格子上的形体的表面积是四周的表面积是4 * h +上底下底面积是2
    //若有相邻的形体，则会有一个面接触，也就是表面积会少了2 * min(这两个形体高度)。
    public static int surfaceArea(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 0)
                    area += 4 * grid[i][j] + 2;
                if (i < grid.length - 1)
                    area -= Math.min(grid[i][j], grid[i + 1][j]) * 2;
                if (j < grid[0].length - 1)
                    area -= Math.min(grid[i][j], grid[i][j + 1]) * 2;
            }
        return area;
    }
}
