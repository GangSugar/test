import java.util.Arrays;
//封装
class Person2{
    private String name;//private修饰，外面的类就不能访问
    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int count;
    public static void change(){
         count = 100;
        //a = 10;error,不可以访问非静态数据成员
    }

    @Override
    public String toString() {
        return "Person2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //构造方法
    //第一种没有参数
    public Person2(){
        this("Java");
        //this("Hello");//java和hello只能调用一个
    }
    //第二种带参数
    public Person2(String name){
        this.name = name;
    }

    {
        System.out.println("实例代码块也叫构造代码块");
    }
    static{
        System.out.println("静态代码块");//静态代码块只能执行一次
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Person2 per = new Person2();
        per.setAge(18);
        per.setName("Java");
        System.out.println(per.getName());
        System.out.println(per.getAge());
        Person2 per2 = new Person2("战三");
        System.out.println(per2.getName());
    }
}

