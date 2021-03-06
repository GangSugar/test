import java.util.*;
class Person {
    int weight;
    int height;

    public Person(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }
}

public class TestDemo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            Person[] arr = new Person[n];
            for (int i = 0; i < n; i++) {
                int index = scan.nextInt();
                arr[index - 1] = new Person(scan.nextInt(), scan.nextInt());
            }
            Arrays.sort(arr, new Comparator<Person>() { //由于Person类本身没有实现内部比较器Comparable接口，所以需要传入一个外部比较器Comparator
                public int compare(Person p1, Person p2) {
                    int tmp = Integer.compare(p1.height, p2.height);  //取得按身高排序的结果
                    if (tmp != 0) {
                        return tmp;
                    } else {   //身高相同的情况下，按体重升序排序
                        return Integer.compare(p1.weight, p2.weight);
                    }
                }
            });
            int[] arr1 = new int[n];
            arr1[0] = 1;
            int max = 0;
            for (int i = 1; i < n; i++) {
                arr1[i] = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i].weight > arr[j].weight || (arr[i].weight == arr[j].weight && arr[i].height == arr[j].height)) {
                        arr1[i] = Math.max(arr1[i], arr1[j] + 1);
                    }
                }
                max = Math.max(max, arr1[i]);
            }
            System.out.println(max);
        }
    }
}