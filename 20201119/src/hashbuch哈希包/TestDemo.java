package hashbuch哈希包;
import java.util.Objects;

class Person {
    int id;
    public Person(int id) {
        this.id = id;
    }
    //重写equals和hashcode方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class HashBuck<K,V>{
    static class Node<K,V>{
        K data;//map.put(key,value)，data就是键key
        V value;
        Node<K,V> next;
        public Node(K data,V value){
            this.data = data;
            this.value = value;
        }
    }
    Node<K,V>[] array;
    int usedSize;
    public HashBuck(){
        this.array =new Node[10];
        usedSize = 0;
    }
    //放入哈希表
    public void put(K key,V value) {

        int hash =  key.hashCode();//找位置
        int index = hash % this.array.length;//合法的下标

        for(Node<K,V> cur = array[index]; cur != null; cur = cur.next) {
            if(cur.data .equals(key) ) {
                cur.value = value;
                return;
            }
        }
        Node<K,V> node = new Node<K,V>(key,value);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
    }
    //根据键去找到值value
    public V getValue(K key) {
        int hash = key.hashCode();
        int index = hash%array.length;
        for (Node<K,V>cur = array[index]; cur != null; cur = cur.next) {
            if(cur.data .equals(key)) {
                return cur.value;
            }
        }
        return null;
    }

    public float loadFactor(){
        return usedSize*1.0f / array.length;
    }
    //扩容
    public void resize(){
        Node<K,V>[] newArray = new Node[2*array.length];
        for (int i = 0;i < array.length;i++){
            Node<K,V> curNext = null;
            for (Node<K,V> cur = array[i]; cur != null; cur = curNext){
                curNext = cur.next;
                //array[i]下标是一个链表
                //cur是头节点
                int hash = cur.data.hashCode();
                int index = hash % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        this.array = newArray;
    }
}


public class TestDemo {
    public static void main(String[] args) {
        Person person1 = new Person(6122);
        Person person2 = new Person(6122);

        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());


        HashBuck<Person,String> hashBuck = new HashBuck<>();
        hashBuck.put(person1,"高博");
        System.out.println(hashBuck.getValue(person2));
    }
}
