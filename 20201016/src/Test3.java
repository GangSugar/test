import jdk.nashorn.internal.ir.CallNode;

class Calculator{
    private double num1;
    private double num2;

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }
    //加法
    public double add(){
        return this.num1+this.num2;
    }
    //减法
    public double sub(){
        return this.num1-this.num2;
    }
    //乘
    public double mul(){
        return this.num1*this.num2;
    }
    //除法
    public double div(){
        return this.num1/this.num2;
    }
    public Calculator() {
        this.num1 = num1;
        this.num2 = num2;
    }

    }
    class  Value{
    public int val;
    }
    public class Test3{
    //交换参数
        public static void swap(Value myval1,Value myval2){
            int tmp = myval1.val;
            myval1.val = myval2.val;
            myval2.val = tmp;
        }
    public static void main(String[] args) {
        Value myval1 =new Value();
        myval1.val = 10;
        Value myval2 =new Value();
        myval2.val = 20;
        swap(myval1,myval2);
        System.out.println(myval1.val+","+myval2.val);
        }
    public static void main1(String[] args) {
        Calculator calculator = new  Calculator();

        calculator.setNum1(10.0);
        calculator.setNum2(12.2);

        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.mul());
        System.out.println(calculator.div());
    }
}