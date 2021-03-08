
public class A<T> {
    T value;

    A(T value) {
        this.value = value;
    }

    public A() {

    }

    T get() {
        return value;
    }
}

class Test2{
    public static void main(String[] args) {
        A<Integer> a = new A(5);
        System.out.println(a.get());

        A<String> ch = new A("小猴子");
        System.out.println(ch.get());
    }
}

