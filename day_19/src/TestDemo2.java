import java.util.*;

//用类存储姓名和成绩
class Person{
    String name;
    int score;
    public Person(String name,int score){
        this.name = name;
        this.score = score;
    }
}
public class TestDemo2{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            //1.首先获取输入的值
            int n = scan.nextInt();//人数
            int m = scan.nextInt();//升序或者降序
            //2.用链表存储姓名和成绩
            List<Person> list = new ArrayList<>();
            for (int i = 0;i < n;i++){
                String name = scan.next();//不能有空格，空格之后就是成绩
                int score = scan.nextInt();
                list.add(new Person(name,score));
            }

            //根据m的值进行升序和排序
            if (m == 0){
                //降序
                //比较器
                Collections.sort(list, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o2.score - o1.score;
                    }
                });
            }else {
                //升序
                //比较器
                Collections.sort(list, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.score - o2.score;
                    }
                });
            }
            for (int i = 0;i < list.size();i++){
                System.out.println(list.get(i).name+" "+list.get(i).score);
            }
        }
    }
}

