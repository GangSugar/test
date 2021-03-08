import java.util.ArrayList;
import java.util.List;
//二维网络迁移https://leetcode-cn.com/problems/shift-2d-grid/solution/er-wei-wang-luo-qian-yi-bi-jiao-rong-yi-li-jie-de-/
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        /*
          分为三种情况
          1.同一行移动的情况
          2.前n-1行，最后面一列需要移动下一行的第一个元素newgrid[1到(n-1)][0] =grid[(0到（n-2)][m-1]
          3.最后一行，最后一列元素移动到第一行第一个元素newgrid[0][0] = grid[n-1][m-1];
         */


        while(k > 0){
            //先定义一个辅助二维网格
            int[][] newGrid = new int[grid.length][grid[0].length];
            //1.同一行移动的情况
            for (int i = 0;i < grid.length;i++){
                for (int j =0;j < grid[0].length-1;j++){
                    newGrid[i][j+1] = grid[i][j];
                }
            }
            //2.前n-1行，最后面一列需要移动下一行的第一个元素,newgrid[1到(n-1)][0] =grid[(0到（n-2)][m-1]
            for (int i = 0;i < grid.length-1;i++){
                newGrid[i+1][0] = grid[i][grid[0].length-1];
            }
            //3.最后一行，最后一列元素移动到第一行第一个元素newgrid[0][0] = grid[n-1][m-1];
            newGrid[0][0] = grid[grid.length-1][grid[0].length-1];

            grid = newGrid;//将移动好的数据放回原来的二维网格
            k--;
        }
        //打印
        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for (int v : row) listRow.add(v);
        }

        return result;
    }

}


public class TestDemo4 {
    public static void main(String[] args) {

    }
}
