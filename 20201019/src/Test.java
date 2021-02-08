import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Test {
    public static void main(String[] args) {
        MyArrayList myarraylist = new MyArrayList(5);
        myarraylist.add(0,1);
        myarraylist.add(0,2);
        myarraylist.display();

        myarraylist.add(4,18);
        myarraylist.display();
        System.out.println(myarraylist.contains(1));
        System.out.println(myarraylist.search(2));

    }
}

