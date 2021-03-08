import java.util.ArrayList;
import java.util.List;

class Student{
    public String name;
    public String cl;
    public double score;

    //构造方法
    public Student(String name, String cl, double score) {
        this.name = name;
        this.cl = cl;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", cl='" + cl + '\'' +
                ", score=" + score +
                '}';
    }
}



public class MyList {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student stu1 = new Student("张三","二班",100);
        Student stu2 = new Student("李四","一班",100);
        Student stu3 = new Student("王五","三班",100);
        list.add(stu1);
        list.add(stu2);
        list.add(stu3);
        for (Student student : list){
            System.out.println(student);
        }

        /*for (int i = 0;i < list.size();i++){
            System.out.println(list.get(i););
        }*/
    }
}
