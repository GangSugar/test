public class Test4 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6}};
        a(arr);
        int[][] arr1 = new int[2][];
        int[][] arr2 = new int[][]{{1,2,3},{4,5,6}};
    }
    //打印二维数组
    public static void a(int[][] arr1){
        for (int i = 0;i < 2;i++){
            for (int j = 0;j < 3;j++){
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }
    }
}
