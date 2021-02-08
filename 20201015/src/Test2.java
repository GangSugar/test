public class Test2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int av = avg(arr);
        System.out.println("数组平均数:" + av);
        System.out.println("数组所有元素之和:" + sum(arr));
        System.out.print("数组每一个元素乘2:");
        printArray(arr);
        int[] ret = new int[100];
        creat(ret);
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i]+" ");
        }
        System.out.println();
        transform(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    public static int avg(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    //数组和
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
    //数组乘2
    public static void transform(int[] array){
        for (int i = 0;i < array.length;i++){
            array[i] *= 2;
        }
    }
    //打印数组
  public static void printArray(int[] array) {
      for (int x : array) {
          System.out.println(x);
      }
  }
  //创建数组
  public static void creat(int[] array) {
        for (int i = 0;i < array.length;i++)
            array[i] = i+1;
  }
}

