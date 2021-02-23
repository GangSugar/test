import java.util.Scanner;

/**
 * https://www.nowcoder.com/practice/1183548cd48446b38da501e58d5944eb?tpId=85&tqId=29840&rp=1&ru=/activity/oj&qru=/ta/2017test/question-ranking
 */
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //输入wh
        while(scan.hasNext()){
            String str = scan.nextLine();
            String[] s = str.split(" ");
            int W = Integer.parseInt(s[0]);
            int H = Integer.parseInt(s[1]);
            int[][] arr = new int[H][W];
            //先全部初始化为1；然后开始遍历，将不能放的全部置为0；并且统计数量

            for(int i = 0;i < H;i++){
                for(int j = 0;j < W;j++){
                    arr[i][j] = 1;
                }
            }

            //开始找不能放蛋糕的位置
            int count = 0;
            for(int i = 0;i < H;i++){
                for(int j = 0;j < W;j++){
                    if(arr[i][j] == 1){
                        count++;
                        if(j+2 < W){
                            arr[i][j+2] = 0;
                        }
                        if(i+2 < H){
                            arr[i+2][j] = 0;
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }
}
//第二种
/*if (W % 4 == 0 || H % 4 == 0){
		counts = W * H / 2;
	}
	else if (W % 2 == 0 && H % 2 == 0){
		counts = (W * H / 4 + 1) * 2;
	}
	else{
		counts = W * H / 2 + 1;
	}*/
/*import java.util.Scanner;
public class TestDemo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0,b = 0;
        while (sc.hasNextInt()) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(fun(a, b));
        }
    }
    public static int fun(int row, int col) {
//每四行四列一个轮回。
        int count = 0;
        for (int i = 0; i < row; i++) {
//处理第一二行
            if (i % 4 == 0 || i % 4 == 1) {
                for (int j = 0; j < col; j++) {
                    if (j % 4 == 0 || j % 4 == 1) {
                        count++;
                    }
                }
            } else {
//处理第二三行
                for (int j = 0; j < col; j++) {
                    if (j % 4 == 2 || j % 4 == 3) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}*/