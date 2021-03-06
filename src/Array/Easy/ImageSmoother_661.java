package Array.Easy;
/*
包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。

示例 1:
输入:
[[1,1,1],[1,0,1],[1,1,1]]
输出:
[[0,0,0],[0,0,0],[0,0,0]]

解释:
对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0

注意:
给定矩阵中的整数范围为 [0, 255]。
矩阵的长和宽的范围均为 [1, 150]。
 */
public class ImageSmoother_661 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] nums = {{1,1,1},{1,0,1},{1,1,1}};
		int[][] a = imagesmoother(nums);
		for (int i = 0; i < a.length; i++) 
			for (int j = 0; j < a[i].length; j++) 
				System.out.println(a[i][j]);
			
	}

	private static int[][] imagesmoother(int[][] nums) {
		// TODO Auto-generated method stub
		int[][] res  = new int[nums.length][nums[0].length];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length; j++) {
				res[i][j]=(dfs(nums,i-1,j-1)+
						dfs(nums,i-1,j)+
						dfs(nums,i-1,j+1)+
						dfs(nums,i,j-1)+
						dfs(nums,i,j)+
						dfs(nums,i,j+1)+
						dfs(nums,i+1,j-1)+
						dfs(nums,i+1,j)+
						dfs(nums,i+1,j+1));
			}
		}
		return res;
	}


	private static int dfs(int[][] nums, int i, int j) {
		// TODO Auto-generated method stub

		if(i<0||i>=nums.length||j<0||j>=nums[i].length){
			return 0;
		}
		else{
			return nums[i][j];
		}
			
			
	}

}
