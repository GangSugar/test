//思路分析：采用递归的方法分别像上下左右四个方向找出口，找到出口以后与上一条比较是否为更省能量的一条路径，
// 如果是，就更新路径，如果不是，就继续递归。

import java.util.Scanner;

/**
 * 牛客地下迷宫
 */
public class TestDemo2 {
    public static String road = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p =sc.nextInt();
        int[][] maze = new int[n][m];
        boolean[][] realroad = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j =0; j < m; j++) {
                maze[i][j] = sc.nextInt();
            }
        }
        Solution(maze,realroad,0,0,"",p);
        System.out.println(road);
    }

    //road是最后唯一的路径
    //tryroad 是尝试的路径，在递归中不断改变最后移动到出口
    public static void Solution(int[][] maze,boolean[][] realroad,int i,
                                int j, String tryroad,int p) {
        if (i == 0 && j == maze[0].length-1 && maze[i][j] == 1) {
            if (p >= 0) {
                road = tryroad + "[" + i + ","+ j + "]";
            } else {
                road = "Can not escape!";
            }
            return;
        }
        if (i >= 0 && j >= 0 && i < maze.length && j < maze[0].length && maze[i][j] == 1 && !realroad[i][j]) {
            realroad[i][j] = true;
            tryroad += "[" + i +"," + j + "]";
            Solution(maze,realroad,i,j+1,tryroad,p-1); //向右
            Solution(maze,realroad,i+1,j,tryroad,p-1); //向下
            Solution(maze,realroad,i,j-1,tryroad,p-1); //向左
            Solution(maze,realroad,i-1,j,tryroad,p-1); //向前

        }
    }
}

