class Calc{
    public int add(int a,int b){
        return a+b;
    }
    public int sub(int a,int b){
        return a-b;
    }
}
//Inheritance
class AdvCalc extends Calc{
    public int multi(int a,int b){
        return a*b;
    }
    public int div(int a,int b){
        return a/b;
    }
}
//MultiLevel Inheritance
class VeryAdvCalc extends AdvCalc{
    public double power(int a,int b){
        return Math.pow(a,b);
    }
}
//Java does not support multiple inhertance ,a single class cannot have more than 1 parent.
public class Hello6 {
    public static void main(String[] args) {
        VeryAdvCalc ref = new VeryAdvCalc();
        int add=ref.add(10,20);
        int sub=ref.sub(10,20);
        int multi=ref.multi(5,5);
        int div = ref.div(10,3);
        double power=ref.power(10,2);
        System.out.println(add+" "+sub+" "+multi+" "+div+" "+power);
    }
}
