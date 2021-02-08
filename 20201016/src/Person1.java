public class Person1 {
    private String name = "张桑";
    private int age = 18;

    //getter/setter方法
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    //方法
    public void show(){
        System.out.println("我叫" + name + ", 今年" + age + "岁");
    }
    public Person1(){
        this.name = "张桑";
       this.age = 18;
    }

    //构造方法（方法名称与类名称相同）
    public Person1(String name,int age){
        this.name = name;
        this.age = age;
    }
}
//测识
class Test1{
    public static void main(String[] args) {
        Person1 per = new Person1();
        per.show();
        Person1 per1 = new Person1("zhang",80);
        per1.show();

    }
}
