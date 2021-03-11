package Generic;

/*
泛型意义
  1.自动进行类型转换;
  2.自动进行类型检查;
泛型只有上界
通配符：
   1.上界：<? extends 上界>
   2.下界：<? super 下界>

内部类：
   1.实例内部类：OuterClass
   2.静态内部类：
   3.匿名内部类：
   4.本地内部类：(不常用)
 */
class MyArrayList<E>{
    E[] elem;
    int usedSize;
    public MyArrayList(){
        elem = (E[])new Object[10];
    }
    public void push(){

    }
    public E get(){
        return elem[0];
    }

}

public class TestDemo2 {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();

    }
}
