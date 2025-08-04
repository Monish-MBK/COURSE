//CLASS AND OBJECT
//Creating a class
class Calculator{
    //creating a method to add
    public int add(int n1,int n2){
        int r = n1+n2;
        return r;
    }
    //Method overloading
    public int add(int n1,int n2,int n3){
        return n1+n2+n3;
    }
}

public class Hello2 {
    public static void main(String[] args) {
        int num1=10;
        int num2=20;
        //type   ref_ variable = new class_name()
        Calculator calc = new Calculator();
              //ref_var.method_name
        int result=calc.add(num1,num2);
        int res = calc.add(num1,num2,30);

        System.out.println(result);
        System.out.println(res);
    }
}
//Method overloading having same method name with different number of parameters or parameter types.