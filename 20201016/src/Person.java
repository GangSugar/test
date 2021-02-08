import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
//类和对象
//什么是类：1.语法：用class定义 2.是一个模板
public class Person {
    //访问修饰限定符：public private   protected   默认
    //成员属性：定义在类的内部，方法的外部
    //成员属性没有初始化的话，那就是默认值，例如int默认就是0，String就是null,boo;ean是false
    public String name = "张三";//初始化
    public int age = 18;//实例成员变量
    public String sex;
    public static int count;//静态成员变量,它不属于对象属于类本身
    public final int SIZE = 10;//(被finall修饰的叫常量，后面将不能在进行更改),属于对象，在堆
    public static final int SIZE1 = 100;//static修饰在方法区
    //方法
    public void show(){
        System.out.println("我叫"+name+",今年"+age+"岁");
        s();
    }

    @Override//(Alt+Insert)健（快捷键可以百度去设置）
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", SIZE=" + SIZE +
                '}';
    }

    public void eat(){
        int a = 10;
        System.out.println("吃饭");
    }
    //静态方法内部不能有非静态成员
    public static void s(){
        //不能访问非静态成员
        //sex = "man";error
        System.out.println("s()");
    }
}

//测试类
/*实例化对象
 1.通过new来实例化
 2.一个类可以实例化多个对象
 */
class Test{
    public static void main(String[] args) {
        System.out.println("hello");
        Person per = new Person();//对象1，类的实例化
        System.out.println(per.name);
        System.out.println(per.age);
        per.show();
        Person per2 = new Person();//对象2,将类实例化
        per.name = "李四";
        per.age = 20;
        per.show();
        System.out.println(per.count);//尽量不要用对象访问静态成员变量
        System.out.println(Person.count);
        Person.s();
        Person per1 = per;//per1这个引用 指向了 per这个引用所指向的  引用（实际就是一个赋值）
        System.out.println(per);//输出的是地址
    }
}
