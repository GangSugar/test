//牛客顺时针打印矩阵
public class TestDemo2 {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int[] res = new int[n*m];
        int index = 0;
        int xuan = (Math.min(n,m)-1)/2+1;//旋转次数
        for(int i = 0;i < xuan;i++){
            for(int j = i;j < m-i;j++){//从左到右边
                res[index++] = mat[i][j];
            }
            for(int k = i+1;k < n-i;k++){//从右上到右下
                res[index++] = mat[k][m-i-1];
            }
            for(int j = m-i-2;(j >= i)&&(n-1-i!=i);j--){//从右下到左下
                res[index++] = mat[n-i-1][j];
            }
            for(int k = n-i-2;(k>i)&&(m-1-i!=i);k--){//从左下到左上
                res[index++] = mat[k][i];
            }
        }
        return res;
    }
}