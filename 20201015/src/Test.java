import java.util.Arrays;

//数组
public class Test {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        int[] ret = func2(array);
        System.out.println(Arrays.toString(ret));
        System.out.println(Arrays.toString(array));
        System.out.println(myToString(array));
        System.out.println(myToString(null));
        int[] tmp = {};
        System.out.println(myToString(tmp));

    }
    //给数组乘2；
    public static int[] func2(int[] array){
        int[] tmp = new int[array.length];
        for (int i = 0;i < tmp.length;i++){
            tmp[i] = array[i];//tmp存放拷贝的数据
        }
        for (int i = 0;i < tmp.length;i++){
            tmp[i] *= 2;
        }
        return tmp;
    }
    //自己写的转字符串方法
    public static String myToString(int[] array){
        if(array == null){
            return "";
        }
        if(array.length == 0){
            return "[]";
        }
        String str= "[";
        for (int i = 0;i < array.length;i++){
            str = str+array[i];
            if(i != array.length-1) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }
    public static void main1(String[] args) {
        System.out.println("hello");
        //数组初始化
        int[] a = new int[] {1,2,3};//动态初始化
        int[] b = {1,2,3};//静态初始化
        int[] c = new int[5];

        //获取数组长度
        System.out.println("数组长度为:"+c.length);

        //访问数组中的元素
        System.out.println(b[1]+","+b[2]);

        //数组赋值
        c[3]=100;
        System.out.println(c[3]);

        //遍历数组
        for (int i = 0;i<b.length;i++){
            System.out.println(b[i]);
        }

        //for-each遍历数组
        for (int x : a){
            System.out.println(x);
        }
        int[] arr = {4,5,6};
        System.out.println("未调用之前：arr[0] = "+arr[0]);
        fun(arr);
        System.out.println("调用之后：arr[0] = "+arr[0]);

        //改变数组
        fac2(arr);
        print(arr);

        //数组转字符串
        int[] s = {1,5,6,9,15};
        String news = Arrays.toString(s);
        System.out.println(news);

        //拷贝数组
        int[] arr1 = {1,2,3,4,5,6};
        int[] newArr = Arrays.copyOf(arr1, arr1.length);
        System.out.println("newArr: " + Arrays.toString(newArr));
        arr1[0] = 10;
        System.out.println("arr: " + Arrays.toString(arr1));
        System.out.println("newArr: " + Arrays.toString(newArr));
        // 拷贝某个范围.
        int[] newArr2 = Arrays.copyOfRange(arr1, 2, 4);
        System.out.println("newArr2: " + Arrays.toString(newArr2));
        //青蛙跳调用
        System.out.println("青蛙跳的方法"+floor(10));
        System.out.println("青蛙跳的方法"+floorFei(10));

    }

    //青蛙跳，递归法
    public static int floor(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return floor(n-1)+floor(n-2);
    }
    //青蛙跳，非递归法
    public static int floorFei(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        int f3 = 0;
        for (int i = 3;i <= n;i++){
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

        //打印数组
    public static void print(int[] a){
        for (int x : a){
            System.out.println(x);
        }
    }

    //引用传参
    public static void fun(int[] a){
        a[0] = 15;
        System.out.println("a[0]:"+a[0]);
    }

    //修改原数组，原*2
    public static void fac2(int[] a){
        for (int i = 0;i<a.length;i++){
            a[i] *=2;
        }
    }

    //public static int a(){}
    public static void func(int[] array){
        array[0] = 99;
    }


}
